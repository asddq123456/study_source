
	function validateMemNm() {
		var checkCustnameResult = joinValidate.checkCustName(jQuery("#memNm").val());
		if( checkCustnameResult.code != 0 ) {
			jQuery("#memNm").removeClass("good");
			jQuery("#memNmState").text(checkCustnameResult.desc);
			jQuery("#memNmState").removeClass("c_good");
			jQuery("#memNmState").addClass("c_invalid");
			return false;
		} else {
			jQuery("#memNm").addClass("good");
			jQuery("#memNmState").text(checkCustnameResult.desc);
			jQuery("#memNmState").removeClass("c_invalid");
			jQuery("#memNmState").addClass("c_good");
			return true;
		}
		return false;
	} //validateMemNm
	
	function validateMemId(btnClickYn) {
		
		jQuery("#checkDupIdYn").val("N");
		
		var checkStringIdResult = joinValidate.checkStringId(jQuery("#memId").val());
		if( checkStringIdResult.code != 0 ) {
			jQuery("#memId").removeClass("good");
			jQuery("#memIdState").text(checkStringIdResult.desc);
			jQuery("#memIdState").removeClass("c_good");
			jQuery("#memIdState").addClass("c_invalid");
			return false;
		} else {
			if( btnClickYn != 'Y' ) {
				if( jQuery("#checkDupIdYn").val() != 'Y' || (jQuery("#checkPrevId").val() != jQuery("#memId").val()) ) {
					jQuery("#memIdState").text("아이디 중복체크버튼을 눌러주세요");
					jQuery("#memIdState").removeClass("c_invalid");
					jQuery("#memIdState").addClass("c_good");
					return true;
				}
			}
			return true;
		}
		return false;
	} //validateMemId
	
	var dupClick = false;
	function checkDupId() {
		
		if( dupClick ) {
			alert("ID 중복확인 중 입니다. 잠시만 기다려주세요.");
			return;
		}
		
		jQuery("#memId").removeClass("good");
		jQuery("#memIdState").removeClass("c_good");
		jQuery("#memIdState").addClass("c_invalid");
		jQuery("#memIdState").text("");
		jQuery("#checkDupIdYn").val("N");
		
		if( validateMemId("Y") ) {
			
			dupClick = true;
			jQuery.ajax({
	            url: '/register/memberJoinAjax.tmall',
		        type: 'POST',
		        dataType: 'json',
		        async: false,
	            data: {
	                method: 'checkDupId',
	                memId: jQuery.trim(jQuery("#memId").val())
	            },
	            success: function(data) {
	            	if( data.checkResult == "SUCCESS" ) {
	            		jQuery("#checkDupIdYn").val("Y");
	            		jQuery("#checkPrevId").val(jQuery("#memId").val());
	            		
						jQuery("#memId").addClass("good");
						jQuery("#memIdState").text("사용가능한 ID입니다.");
						jQuery("#memIdState").removeClass("c_invalid");
						jQuery("#memIdState").addClass("c_good");
						
						dupClick = false;
						
						return;
						
					} else if( data.checkResult == "FORBIDDEN" ) {
						
						//alert("금칙어는 입력할 수 없습니다.");
						dupClick = false;
						
						jQuery("#memId").removeClass("good");
						jQuery("#memIdState").text("금칙어는 입력할 수 없습니다.");
						jQuery("#memIdState").removeClass("c_good");
						jQuery("#memIdState").addClass("c_invalid");
						
						return;
						
					} else if( data.checkResult == "DUPLICATE" ) {
						
						//alert("이미 사용중인 ID 입니다.");
						dupClick = false;
						
						jQuery("#memId").removeClass("good");
						jQuery("#memIdState").text("이미 사용중인 ID 입니다.");
						jQuery("#memIdState").removeClass("c_good");
						jQuery("#memIdState").addClass("c_invalid");
						
						return;
						
					} else {
						alert("ID 중복확인이 실패하였습니다.");
						dupClick = false;
						return;
					}
				},
				error: function() {
					alert("ID 중복확인이 실패하였습니다!");
					dupClick = false;
					return;
				}
			});
		}
	} //checkDupId
	
	function validateMemPwd() {
		var memPwd = jQuery.trim(jQuery("#memPwd").val());
		var checkPwdResult = safety.safetyCheck(memPwd);
		if( checkPwdResult != 'SUCC' ) {
			jQuery("#memPwd").removeClass("good");
			jQuery("#memPwdState").text(checkPwdResult.desc);
			jQuery("#memPwdState").removeClass("c_good");
			jQuery("#memPwdState").addClass("c_invalid");
			return false;
			
		} else {
			/* ID와 비밀번호 비교 */
			var memId = jQuery.trim(jQuery("#memId").val());
			var checkPwdCompareTargetResult = safety.checkPwdCompareTarget(memId, memPwd, 3);
			if( checkPwdCompareTargetResult != 'SUCC' ) {
				jQuery("#memPwd").removeClass("good");
				jQuery("#memPwdState").text(checkPwdCompareTargetResult.desc);
				jQuery("#memPwdState").removeClass("c_good");
				jQuery("#memPwdState").addClass("c_invalid");
				return false;
			}
			/* 휴대폰번호와 비밀번호 비교 */
			var prtblTlphnNo = jQuery.trim(jQuery("#prtblTlphnNo").val());
			checkPwdCompareTargetResult = safety.checkPwdCompareTarget(prtblTlphnNo, memPwd, 4);
			if( checkPwdCompareTargetResult != 'SUCC' ) {
				jQuery("#memPwd").removeClass("good");
				jQuery("#memPwdState").text(checkPwdCompareTargetResult.desc);
				jQuery("#memPwdState").removeClass("c_good");
				jQuery("#memPwdState").addClass("c_invalid");
				return false;
			}
			
			checkPwdResult = safety.checkSafetyPw(memPwd);
			if( checkPwdResult == '1' ) {
				jQuery("#memPwd").removeClass("good");
				jQuery("#memPwdState").text("좀 더 안전한 비밀번호로 설정해주세요.");
				jQuery("#memPwdState").removeClass("c_good");
				jQuery("#memPwdState").addClass("c_invalid");
				return true;
				
			} else if( checkPwdResult == '2' ) {
				jQuery("#memPwd").addClass("good");
				jQuery("#memPwdState").text("안전한 비밀번호 입니다");
				jQuery("#memPwdState").removeClass("c_invalid");
				jQuery("#memPwdState").addClass("c_good");
				return true;
				
			} else {
				jQuery("#memPwd").addClass("good");
				jQuery("#memPwdState").text("예측이 어려운 강력한 비밀번호 입니다.");
				jQuery("#memPwdState").removeClass("c_invalid");
				jQuery("#memPwdState").addClass("c_good");
				return true;
			}
		}
		return false;
	} //validateMemPwd
	
	function validateReMemPwd() {
		if( validateMemPwd() ) {
			var memPwd = jQuery.trim(jQuery("#memPwd").val());
			var reMemPwd = jQuery.trim(jQuery("#reMemPwd").val());
			if( reMemPwd == '' ) {
				jQuery("#reMemPwd").removeClass("good");
				jQuery("#reMemPwdState").text("비밀번호를 다시 한번 입력해 주세요.");
				jQuery("#reMemPwdState").removeClass("c_good");
				jQuery("#reMemPwdState").addClass("c_invalid");
				return false;
				
			} else {
				if( memPwd != reMemPwd ) {
					jQuery("#reMemPwd").removeClass("good");
					jQuery("#reMemPwdState").text("비밀번호와 일치하지 않습니다.");
					jQuery("#reMemPwdState").removeClass("c_good");
					jQuery("#reMemPwdState").addClass("c_invalid");
					return false;
					
				} else {
					jQuery("#reMemPwd").addClass("good");
					jQuery("#reMemPwdState").text("비밀번호 일치");
					jQuery("#reMemPwdState").removeClass("c_invalid");
					jQuery("#reMemPwdState").addClass("c_good");
					return true;
				}
			}
		}
		return false;
	} //validateReMemPwd
	
	function validateEmail() {
		var emailAddr = jQuery.trim(jQuery("#email").val());
		var checkEmailResult = joinValidate.checkEmail(emailAddr);
		if( checkEmailResult.code != 0 ) {
			jQuery("#email").removeClass("good");
			jQuery("#emailState").text(checkEmailResult.desc);
			jQuery("#emailState").removeClass("c_good");
			jQuery("#emailState").addClass("c_invalid");
			return false;
		} else {
			if( !validEmailAddr(emailAddr) ) {
				jQuery("#email").removeClass("good");
				jQuery("#emailState").text("이메일 주소가 유효하지 않습니다.");
				jQuery("#emailState").removeClass("c_good");
				jQuery("#emailState").addClass("c_invalid");
				return false;
			}
			jQuery("#email").addClass("good");
			jQuery("#emailState").text(checkEmailResult.desc);
			jQuery("#emailState").removeClass("c_invalid");
			jQuery("#emailState").addClass("c_good");
			return true;
		}
		return false;
	} //validateEmail
	
	function validatePrtblTlphnNo() {
		var prtblTlphnNo = jQuery.trim(jQuery("#prtblTlphnNo").val());
		var checkPhoneNumResult = joinValidate.checkPhoneNum(prtblTlphnNo);
		if( checkPhoneNumResult.code != 0 ) {
			jQuery("#prtblTlphnNo").removeClass("good");
			jQuery("#prtblTlphnNoState").text(checkPhoneNumResult.desc);
			jQuery("#prtblTlphnNoState").removeClass("c_good");
			jQuery("#prtblTlphnNoState").addClass("c_invalid");
			return false;
		} else {
			jQuery("#prtblTlphnNo").addClass("good");
			jQuery("#prtblTlphnNoState").text(checkPhoneNumResult.desc);
			jQuery("#prtblTlphnNoState").removeClass("c_invalid");
			jQuery("#prtblTlphnNoState").addClass("c_good");
			return true;
		}
		return false;
	} //validatePrtblTlphnNo
	
	function doJoin() {
		
	
		
		if( joinDblClick ) {
			alert("회원가입 처리 중입니다. 잠시만 기다려주세요.");
			return;
		}
		
		if( !validateMemNm() ) {
			jQuery("#memNm").focus();
			return;
		}
		
		if( jQuery("#checkDupIdYn").val() != 'Y' || (jQuery("#checkPrevId").val() != jQuery("#memId").val()) ) {
			alert("아이디 중복체크버튼을 눌러주세요");
			jQuery("#memIdState").text("아이디 중복체크버튼을 눌러주세요");
			jQuery("#memIdState").removeClass("c_invalid");
			jQuery("#memIdState").addClass("c_good");
			return;
		}
		
		if( !validateMemPwd() ) {
			jQuery("#memPwd").focus();
			return;
		}
		
		if( !validateReMemPwd() ) {
			jQuery("#memReMemPwd").focus();
			return;
		}
		
		if( !validateEmail() ) {
			jQuery("#email").focus();
			return;
		}
		
		if( !validatePrtblTlphnNo() ) {
			jQuery("#prtblTlphnNo").focus();
			return;
		}
		
		doJoinAjax();
	} //doJoin
	
	var joinDblClick = false;
	function doJoinAjax() {
		var smsRcvAgree = jQuery("#smsRcvAgree_Em").hasClass("on") ? "Y" : "N";
		var emailRcvAgree = jQuery("#emailRcvAgree_Em").hasClass("on") ? "Y" : "N";
		
		joinDblClick = true;
		jQuery.ajax({
            url: '/register/memberJoinAjax.tmall',
	        type: 'POST',
	        dataType: 'json',
	        async: false,
            data: {
                method: 'doMemberJoinPrvtBuyer',
                tknKey: jQuery("#tknKey").val(),
                memNm: encodeURIComponent(jQuery("#memNm").val()),
                memId: jQuery.trim(jQuery("#memId").val()),
                memPwd: jQuery.trim(jQuery("#memPwd").val()),
            	email: jQuery.trim(jQuery("#email").val()),
            	entCmmnClf: jQuery("#entCmmnClf option:selected").val(),
            	prtblTlphnNo: jQuery.trim(jQuery("#prtblTlphnNo").val()),
            	smsRcvAgree: smsRcvAgree,
            	emailRcvAgree: emailRcvAgree
            },
            success: function(data) {
            	if( data.resultId == 'SUCCESS' ) {
            		// 회원가입 완료
            		location.replace("https://www.11st.co.kr/register/memberJoin.tmall?method=memberJoinPrvtBuyerComplete&tknKey="+data.completeTknKey+"&smsRcvAgree="+smsRcvAgree+"&emailRcvAgree="+emailRcvAgree);
            		
            	} else if( data.resultId == 'DUPLICATE' ) {
            		// 이미 가입처리된 회원입니다.
            		alert("이미 사용중인 아이디입니다.");
            		joinDblClick = false;
            		jQuery("#memId").focus();
            		jQuery("#memId").removeClass("good");
					jQuery("#memIdState").text("이미 사용중인 ID 입니다.");
					jQuery("#memIdState").removeClass("c_good");
					jQuery("#memIdState").addClass("c_invalid");
					return;
					
            	} else if( data.resultId == 'FORBIDDEN_ID' ) {
            		alert("금칙어는 입력할 수 없습니다.");
            		joinDblClick = false;
            		jQuery("#memId").focus();
            		jQuery("#memId").removeClass("good");
					jQuery("#memIdState").text("금칙어는 입력할 수 없습니다.");
					jQuery("#memIdState").removeClass("c_good");
					jQuery("#memIdState").addClass("c_invalid");
					return;
					
            	} else if( data.resultId == 'FORBIDDEN_NAME' ) {
            		alert("금칙어는 입력할 수 없습니다.");
            		joinDblClick = false;
            		jQuery("#memNm").focus();
            		jQuery("#memNm").removeClass("good");
					jQuery("#memNmState").text("금칙어는 입력할 수 없습니다.");
					jQuery("#memNmState").removeClass("c_good");
					jQuery("#memNmState").addClass("c_invalid");
					return;
					
            	} else if( data.resultId == 'PARAM_WRONG' ) {
            		alert("회원가입 실패하였습니다!");
            		joinDblClick = false;
            		return;
            	} else if( data.resultId == 'TKN_EXPIRE' ) {
            		alert("잘못된 경로로 진입하셨거나 시간이 만료되었습니다.");
            		joinDblClick = false;
            		location.replace("http://www.11st.co.kr/register/memberSubscribeOneIDForm.page");
            	} else {
            		alert("회원가입 실패하였습니다!!");
            		joinDblClick = false;
            		return;
            	}
			},
			error: function() {
				alert("회원가입 실패하였습니다!!!");
				joinDblClick = false;
				return;
			}
		});
	} //doJoinAjax
	
	function checkNum(obj, value) {
		var regExp = /[^0-9]+/g;
        if(regExp.test(value)) {
            //alert("'숫자' 만 입력 가능합니다.");
            var returnStr = "";
            for(i = 0; i < value.length; i++) {
                if(value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                    returnStr += value.charAt(i);
                }
            }
            obj.value = returnStr;
            obj.focus();
        }
    }
	
	function validEmailAddr(strValue) {
		var regExp = /^[0-9a-zA-Z][_a-zA-Z0-9-\.]+@[\.a-zA-Z0-9-]+\.[a-zA-Z]+$/;
		
		//입력을 안했으면
		if(strValue.lenght == 0) {
			return false;
		}
		//이메일 형식에 맞지않으면
		if (!strValue.match(regExp)) {
			return false;
		}
		return true;
	}
	
	jQuery(function() {
		jQuery("#idJoinHelp").click(function (e) {
			jQuery("#idPop").addClass('layer_view');
		});
		jQuery("#pwdJoinHelp").click(function (e) {
			jQuery("#pwdPop").addClass('layer_view');
		});
		jQuery("#smsRcvAgree").click(function(){
			var checked = jQuery("#smsRcvAgree_Em").hasClass("on");
			if(checked) {
				jQuery("#smsRcvAgree_Em").removeClass("on");
			} else {
				jQuery("#smsRcvAgree_Em").addClass("on");
			}
		});
		jQuery("#emailRcvAgree").click(function(){
			var checked = jQuery("#emailRcvAgree_Em").hasClass("on");
			if(checked) {
				jQuery("#emailRcvAgree_Em").removeClass("on");
			} else {
				jQuery("#emailRcvAgree_Em").addClass("on");
			}
		});
		jQuery("#memId").blur(function() {
			if( jQuery.trim(jQuery("#memId").val()) == '' ) {
				jQuery("#memIdState").text("아이디를 입력해 주세요");
				jQuery("#memIdState").removeClass("c_invalid");
				jQuery("#memIdState").addClass("c_good");
			}
		});
		
		jQuery("#smsHelp").click(function (e) {
			jQuery("#smsPop").addClass('layer_view');
		});
		jQuery("#emailHelp").click(function (e) {
			jQuery("#emailPop").addClass('layer_view');
		});
	});
	
	