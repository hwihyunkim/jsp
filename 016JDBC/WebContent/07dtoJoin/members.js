function infoConfirm(){
	
	if(document.reg_form.id.value.length==0){
		alert("아이디는 필수 사항입니다.");
		reg_form.id.focus();
		return;
	}
	
	if(document.reg_form.id.value.length<4){
		alert("아이디는 4글자 이상이여야 합니다.");
		reg_form.id.forcus();
		return;
	}
	
	if(document.reg_form.pw.value.length<4){
		alert("아이디는 4글자 이상이여야 합니다.");
		reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.pw.value!=document.reg_form.pw_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		reg_form.pw.focus();
		return;
	}
	
	document.reg_form.submit();
	
}

function updateInfoConfirm(){
	if(document.reg_form.pw.value==""){
		alert("패스워드를 입력하세요.");
		documetn.reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.pw.value!=documetn.reg_form.pw_check.value){
		alert("패스워드가 일치하지 않습니다.");
		documetn.reg_form.pw.focus();
	}
	
	if(document.reg_form.mail.value.length==0){
		alert("메일은 필수 사항입니다.");
		reg_form.mail.focus();
	}
	
	document.reg_form.submit();
}