package kr.ko.ym.common.api;

import net.bytebuddy.description.field.FieldDescription;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class GithubApi implements Comparator<Map<String,Object>> {

    public List<Map<String,Object>> getIssueRecentComments(String token, String repoName) throws IOException {

        GitHub gitHub = new GitHubBuilder().withOAuthToken(token).build();
        gitHub.checkApiUrlValidity();

        GHRepository repo = gitHub.getRepository(repoName);
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);


        List<GHIssueComment> allComments = new ArrayList();
        List<String>boardIdx = new ArrayList<>();


        for(GHIssue issue : issues) {
            //사이트에서 단 댓글만 골라 가져오기(label = comments 로 지정함)
            if(issue.getLabels()
                    .stream()
                    .anyMatch(label -> label.getName().equals("comments"))){

                //코멘트
                for(int i = 0; i < issue.getCommentsCount(); i++){
                    String title = issue.getTitle();

                    boardIdx.add(title.substring(title.length()-title.lastIndexOf("/")));
                    allComments.add(issue.getComments().get(i));
                }
            }
        }

        List<Map<String,Object>> recent = new ArrayList<Map<String, Object>>();

        //GHIssueComment 객체에서 필요한 데이터만 map에 담음
        for(int i = 0; i < allComments.size(); i++){
            Map<String,Object>map = new HashMap<>();

            GHIssueComment gc = allComments.get(i);

            map.put("idx", boardIdx.get(i));
            map.put("update", gc.getUpdatedAt());
            map.put("comment", gc.getBody());
            map.put("userName", gc.getUser().getLogin());
            map.put("imgUrl", gc.getUser().getAvatarUrl());

            recent.add(map);
        }

        //날짜 순으로 정렬(역정렬)
        Collections.sort(recent, new GithubApi());

        //최대 5개만
        return recent.subList(0, recent.size() == 5 ? 5 : recent.size());

    }

    @Override
    public int compare(Map<String, Object> a, Map<String, Object> b) {

        Date prev = (Date) a.get("update");
        Date next = (Date) b.get("update");

        if(prev.compareTo(next) == 1){
            return -1;
        }else if(prev.compareTo(next) == -1){
            return 1;
        }else{
            return 0;
        }
    }
}
