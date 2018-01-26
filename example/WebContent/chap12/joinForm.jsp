<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/member.css" type="text/css">
<link rel="stylesheet" href="/resources/css/default.css" type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/form.js"></script>
<script type="text/javascript" src="/resources/js/joinValidate.js"></script>
<script type="text/javascript" src="/resources/js/form2.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>
</head>
<body>
	<script>
		function moveTop() {
			location.hash = 'focus_topAgree';
		}
	</script>

	<div class="join_personal" id="wrapBody">
		<h1 class="join_header"></h1>
		<div id="layBodyWrap">
			<div id="layBody">
				<!-- content -->

				<div class="joinWarp">
					<div class="head_area">
						<h2>개인 구매회원 가입</h2>
						<ol class="location">
						</ol>
					</div>

					<span class="txt_join">회원정보를 입력해 주세요. 모두 입력하셔야 가입이 가능합니다.</span>


					<div class="main_area">
						<div class="join_form">
							<form name="joinForm">
								<table>
									<caption>개인정보입력</caption>
									<colgroup>
										<col width="145px" />
										<col width="*" />
									</colgroup>
									<tbody>
										<input type="hidden" id="tknKey"
											value="29ce10c1891742de8ae4542c763b132311987f2c9f6ff5e2d6afdf7e99229fae7c74b598" />
										<tr>
											<th scope="row"><label for="memNm"><strong
													class="required">필수</strong>이름</label></th>
											<td>
												<div class="stateTxt">
													<input type="text" id="memNm" name="memNm" class="text"
														style="width: 365px;" maxlength="100"
														placeholder="이름을 입력해 주세요" autocomplete="off"
														onkeyup="javascript:validateMemNm();" /> <span
														class="state" id="memNmState"></span>
												</div>
											</td>
										</tr>
										<tr>
											<th scope="row"><label for="memId"><strong
													class="required">필수</strong>ID</label> <a class="join_help"
												id="idJoinHelp">도움말</a></th>
											<td><input type="text" id="memId" name="memId"
												class="text" style="width: 256px;" maxlength="50"
												placeholder="ID를 입력해 주세요" autocomplete="off"
												onkeyup="javascript:validateMemId('N');"
												onfocus="javascript:validateMemId('N');" />
												<button type="button" class="defbtn_lar ladtype4"
													id="dupBtn"
													onclick="javascript:checkDupId();rakeLog.sendRakeLog(this);"
													data-log-actionid-area="id_duplication"
													data-log-actionid-label="btn">
													<span>중복확인</span>
												</button> <span class="state c_good" id="memIdState">아이디를 입력해
													주세요</span> <input type="hidden" id="checkDupId" name="checkDupId"
												value="N" /></td>
										</tr>
										<tr>
											<th scope="row"><label for="memPwd"><strong
													class="required">필수</strong>비밀번호</label> <a class="join_help"
												id="pwdJoinHelp">도움말</a></th>
											<td><input type="password" id="memPwd" name="memPwd"
												class="text" style="width: 256px;" maxlength="50"
												placeholder="비밀번호를 입력해 주세요" autocomplete="off"
												onkeyup="javascript:validateMemPwd();" /> <span
												class="state" id="memPwdState"></span></td>
										</tr>
										<tr>
											<th scope="row"><label for="reMemPwd"><strong
													class="required">필수</strong>비밀번호 확인</label></th>
											<td><input type="password" id="reMemPwd" name="reMemPwd"
												class="text" style="width: 256px;" maxlength="50"
												placeholder="비밀번호를 다시 한번 입력해 주세요" autocomplete="off"
												onkeyup="javascript:validateReMemPwd();" /> <span
												class="state" id="reMemPwdState"></span></td>
										</tr>
										<tr>
											<th scope="row"><label for="email"><strong
													class="required">필수</strong>이메일</label></th>
											<td><input type="text" id="email" name="email"
												class="text" style="width: 256px;" maxlength="50"
												placeholder="이메일을 입력해주세요" autocomplete="off"
												onkeyup="javascript:validateEmail();" /> <span
												class="state" id="emailState"></span></td>
										</tr>
										<tr>
											<th scope="row"><label for="entCmmnClf"><strong
													class="required">필수</strong>휴대폰</label></th>
											<td><select title="휴대폰 앞자리" class="type3"
												id="entCmmnClf" name="entCmmnClf">
													<option value='01'>SKT</option>
													<option value='02'>LGT</option>
													<option value='03'>KT</option>
													<option value='04'>기타통신사</option>

											</select> <span class="hypen">-</span> <input type="text" class="text"
												id="prtblTlphnNo" name="prtblTlphnNo" maxlength="12"
												style="width: 156px;" title="휴대폰 번호 뒷자리"
												placeholder="휴대폰 번호(-제외)" autocomplete="off"
												onkeyup="javascript:checkNum(this, this.value); validatePrtblTlphnNo();" />
												<span class="state" id="prtblTlphnNoState"></span></td>
										</tr>
										<tr>
											<th scope="row"><span class="cover_txt">수신동의</span></th>
											<td>
												<div class="">
													<input type="checkbox" id="smsRcvAgree" name="smsRcvAgree" value="y"/>
													<label for="smsRcvAgree"><em class="chkbox"
														id="smsRcvAgree_Em">Check</em><span>이벤트/쇼핑혜택 SMS 수신
															동의</span></label> <span class="txt_sub">(선택)</span> <a class="join_help"
														id="smsHelp">도움말</a>
												</div>
												<div class="">
													<input type="checkbox" id="emailRcvAgree" value="y"
														name="emailRcvAgree"> <label for="emailRcvAgree"><em
														class="chkbox" id="emailRcvAgree_Em"></em><span>이벤트/쇼핑혜택
															이메일 수신 동의</span></label> <span class="txt_sub">(선택)</span> <a
														class="join_help" id="emailHelp">도움말</a>
												</div>
											</td>
										</tr>
									</tbody>
								</table>

								<!-- 도움말 레이어팝업 -->
								<div class="layerPop" id="idPop" tabindex="0">
									<div class="layerCnt">
										<ul>
											<li>6~50자의 영문 소문자, 숫자, 특수기호 일부만 사용할 수 있습니다.</li>
											<li>사용 가능한 특수기호 :- . _ (공백입력 불가)</li>
											<li>일반 문자열로만 입력이 가능합니다 (이메일 형식 불가)</li>
											<li>첫글자는 특수문자 불가능, 숫자는 가능합니다.</li>
										</ul>
									</div>
									<div class="btnBox">
										<button type="button" class="defbtn_lsm dtype">
											<span>확인</span>
										</button>
									</div>
									<div class="layClose">
										<button type="button">
											<span>레이어 닫기</span>
										</button>
									</div>
								</div>

								<div class="layerPop" id="pwdPop" tabindex="0">
									<div class="layerCnt">
										<ul>
											<li>비밀번호는 6~20자의 영문 대소문자 및 숫자 조합으로 설정이 가능하며, 일부 특수기호도
												사용할 수 있습니다. (공백입력불가)</li>
											<li>사용 가능한 특수기호 :
												!@#$%^&amp;*()-_+=|[]{}'";:/?.&gt;,&lt;</li>
											<li>3자 이상 연속 영문/숫자 조합은 불가,</li>
											<li>아이디에 포함된 문자/숫자와 연속 3자 이상 동일한 비밀번호는 설정이 불가합니다.</li>
										</ul>
									</div>
									<div class="btnBox">
										<button type="button" class="defbtn_lsm dtype">
											<span>확인</span>
										</button>
									</div>
									<div class="layClose">
										<button type="button">
											<span>레이어 닫기</span>
										</button>
									</div>
								</div>
								<!-- //도움말 레이어팝업 -->
								<!-- [16-06-30 diapen] SR-52606 SMS/Email 수신 동의 시 고지내용 추가 -->
								<div class="layerPop large layer_view" id="smsPop">
									<h3 class="layerTit">이벤트/쇼핑혜택 수신 동의 안내</h3>
									<div class="layerCnt">
										<p>
											<strong>마케팅 활용을 위한 개인정보 수집이용동의(선택)</strong>
										</p>
										<p>고객님께서는 동의를 거부하실 수 있으며, 동의하지 않아도 가입이 가능합니다.</p>
										<table class="tbl">
											<caption>이벤트/쇼핑혜택 수신 동의 안내</caption>
											<colgroup>
												<col style="width: 32%">
												<col style="width: 21%">
												<col style="width: 47%">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">이용목적</th>
													<th scope="col">수집항목</th>
													<th scope="col">보유기간</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>쇼핑이벤트 및 혜택 알림 서비스 제공</td>
													<td>휴대폰번호</td>
													<td>회원탈퇴 또는 개인정보 유효기간 도래 시 까지 보관<br>*단, 관계 법령에 따라
														고객님의 개인정보를 보존하여야 하는 경우, 회사는 해당 법령에서 정한 기간 동안 보관합니다.
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="btnBox">
										<button type="button" class="defbtn_lsm dtype">
											<span>확인</span>
										</button>
									</div>
									<div class="layClose">
										<button type="button">
											<span>레이어 닫기</span>
										</button>
									</div>
								</div>

								<div class="layerPop large layer_view" id="emailPop">
									<h3 class="layerTit">이벤트/쇼핑혜택 수신 동의 안내</h3>
									<div class="layerCnt">
										<p>
											<strong>마케팅 활용을 위한 개인정보 수집이용동의(선택)</strong>
										</p>
										<p>고객님께서는 동의를 거부하실 수 있으며, 동의하지 않아도 가입이 가능합니다.</p>
										<table class="tbl">
											<caption>이벤트/쇼핑혜택 수신 동의 안내</caption>
											<colgroup>
												<col style="width: 32%">
												<col style="width: 21%">
												<col style="width: 47%">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">이용목적</th>
													<th scope="col">수집항목</th>
													<th scope="col">보유기간</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>쇼핑이벤트 및 혜택 알림 서비스 제공</td>
													<td>이메일주소</td>
													<td>회원탈퇴 또는 개인정보 유효기간 도래 시 까지 보관<br>*단, 관계 법령에 따라
														고객님의 개인정보를 보존하여야 하는 경우, 회사는 해당 법령에서 정한 기간 동안 보관합니다.
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="btnBox">
										<button type="button" class="defbtn_lsm dtype">
											<span>확인</span>
										</button>
									</div>
									<div class="layClose">
										<button type="button">
											<span>레이어 닫기</span>
										</button>
									</div>
								</div>
								<!-- //[16-06-30 diapen] SR-52606 SMS/Email 수신 동의 시 고지내용 추가 -->
								<!-- //도움말 레이어팝업 -->
							</form>
						</div>
					</div>
					<div class="btn_area">
						<button type="button" class="defbtn_xlar xladtype"
							onclick="javascript:join_go();" data-log-actionid-area="join"
							data-log-actionid-label="btn">
							<span>회원가입</span>
						</button>
					</div>
				</div>
				<!-- //content -->
			</div>
		</div>
	</div>

	<script>
		jQuery('.layerPop > .layClose > button ').click(function(e) {
			jQuery(this).closest('.layerPop').removeClass('layer_view');
			return false;
		});
		jQuery('.layerPop > .btnBox > button ').click(function(e) {
			jQuery(this).closest('.layerPop').removeClass('layer_view');
			return false;
		});

		jQuery("#smsPop").removeClass('layer_view');
		jQuery("#emailPop").removeClass('layer_view');
	</script>

</body>
<!--// 본문 내용 끝 //-->
<script>
	function join_go() {
		var validOK = true;
		/* 유효성 검사 
			통과 : validOK=true;		
			실패 : validOK=false;
		 */
		if (validOK) {
			var form = document.joinForm;
			form.action = "/member/join";
			form.method = "post"
			form.submit();
		}
	};
</script>

<!-- footer -->

</html>











