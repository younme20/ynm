/**
 * 
 */
const onClickGoogleLogin = (e) => {
    	//구글 인증 서버로 인증코드 발급 요청
 		window.location.replace("https://accounts.google.com/o/oauth2/v2/auth?client_id=yourClientID&redirect_uri=http://localhost:8080/login/google/auth" +
 				"&response_type=code&scope=email%20profile%20openid&access_type=offline")
 	}
	
	
	$("#googleLoginBtn").bind("click", function(e) {
		
		onClickGoogleLogin(e);
	});
	
	function attachSignin(element) {
	    auth2.attachClickHandler(element, {},
	        function(googleUser) {
	    		var id_token = googleUser.getAuthResponse().id_token;
	    		
	    		var xhr = new XMLHttpRequest();
	    		xhr.open('POST', '/ynm/googleLogin');
	    		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    		xhr.onload = function() {
	    		  console.log('Signed in as: ' + xhr.responseText);
	    		};
	    		xhr.send('idtoken=' + id_token);
	    		
	        }, function(error) {
	          console.log(JSON.stringify(error, undefined, 2));
	        });
	  }