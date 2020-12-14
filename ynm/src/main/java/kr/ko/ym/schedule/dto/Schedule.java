package kr.ko.ym.schedule.dto;

public class Schedule {

    int Idx;
    String StartDate;
    String EndDate;
    String Title;
    String Color;
    String Memo;
    String DoneFlag;
    String Username;

    public Schedule(int idx,
                    String startDate,
                    String endDate,
                    String title,
                    String color,
                    String memo,
                    String doneFlag,
                    String username) {
        Idx = idx;
        StartDate = startDate;
        EndDate = endDate;
        Title = title;
        Color = color;
        Memo = memo;
        DoneFlag = doneFlag;
        Username = username;
    }

    public int getIdx() {
        return Idx;
    }

    public void setIdx(int idx) {
        Idx = idx;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public String getDoneFlag() {
        return DoneFlag;
    }

    public void setDoneFlag(String doneFlag) {
        DoneFlag = doneFlag;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
