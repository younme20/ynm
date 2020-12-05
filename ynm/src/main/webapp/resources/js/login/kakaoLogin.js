/**
 * 
 */
$(document).ready(function(){ 		
$("a[id='kakaoLogin']").on("click", function(e){ 
		movePage("https://kauth.kakao.com/oauth/authorize?client_id=9ca8233e7498809ecb8e4dedc89f00fe&redirect_uri=http://localhost:8090/ynm/kakaologin&response_type=code");
	});
});

/*

  Kakao.init('cbd240304d9fcadf483fd88889853541');
  var loginWithKakao = function() {
    Kakao.Auth.login({
      success: function(authObj) {
        console.log(JSON.stringify(authObj));
       // userLogin(authObj);
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
  var userLogin  = function(code){
	  movePage("/ynm/login?code="+code);
  }*/