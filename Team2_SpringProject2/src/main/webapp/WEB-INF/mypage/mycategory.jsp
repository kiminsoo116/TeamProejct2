<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h4{
position:absolute;
top:0px;
left:0px;
font-weight:700;
z-index: 3;
}
h5{
position:absolute;
top:80px;
font-weight:700;
font-size: 30px;
color:#afd4ef;
}
.tagposition{
position:absolute;
width:1220px;
height:300px;
left:0%;
top:250px;
}
.tagchip0,.tagchip1,.tagchip2,.tagchip3,.tagchip4,.tagchip5,.tagchip6,.tagchip7,.tagchip8,.tagchip9,
.tagchip10,.tagchip11,.tagchip12,.tagchip13,.tagchip14,.tagchip15,{
border-radius: 50px;
background: none;
border:2px solid #568bff;
color:#568bff;
font-weight: 500px;
margin:10px;
}
.writecate{
position:absolute;
top:150px;
width:1200px;
height:50px;
border:none;
font-size: 30px;
font-weight: 700px;
color:#568bff;
}
p{
font-size: 50px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="contentbox">
<h4>관심 카테고리</h4>
<div class="divider"></div>
<h5>"회원님은 어떤 동아리에 관심을 갖고 계신가요?"</h5>

<div class="tags">
<div>
<p>{{msg}}</p>
<!-- <h5>"</h5><input type="text" class="writecate"id="writecate" size=100 v-model="writecate" :value="selectcate"><h5>"</h5> -->
<!-- <p>{{selectcate}}</p> -->
</div>
<div class="tagposition">

<select>
<option>요리 / 제조</option>
<option>아웃도어 / 여행</option>
<option>운동 / 스포츠</option>
</select>
<%-- <c:forEach var="i" begin="0" end="15">
<button id="i" value="${list[i] }" class="tagchip" v-model="i" v-on:click="putcate()">${list[i] }</button>&nbsp;&nbsp;/&nbsp;&nbsp; --%>
<!-- <button :id="0" value="요리 / 제조" class="tagchip0" v-on:click="putcate()" v-model="tag0">요리 / 제조</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="1" value="아웃도어 / 여행" class="tagchip1" v-on:click="putcate()" v-model="tag1">아웃도어 / 여행</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="2" value="운동 / 스포츠" class="tagchip2" v-on:click="putcate()" v-model="tag2">운동 / 스포츠</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="3" value="인문학 / 책 / 글" class="tagchip3" v-on:click="putcate()" v-model="tag3">인문학 / 책 / 글</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="4" value="업무 / 직무" class="tagchip4" v-on:click="putcate()" v-model="tag4">업무 / 직무</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="5" value="외국 / 언어" class="tagchip5" v-on:click="putcate()" v-model="tag5">외국 / 언어</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="6" value="문화 / 공연 / 축제" class="tagchip6" v-on:click="putcate()" v-model="tag6">문화 / 공연 / 축제</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="7" value="음악 / 악기" class="tagchip7" v-on:click="putcate()" v-model="tag7">음악 / 악기</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="8" value="공예 / 만들기" class="tagchip8" v-on:click="putcate()" v-model="tag8">공예 / 만들기</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="9" value="댄스 / 무용" class="tagchip9" v-on:click="putcate()" v-model="tag9">댄스 / 무용</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="10" value="봉사활동" class="tagchip10" v-on:click="putcate()" v-model="tag110">봉사활동</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="11" value="사교 / 인맥" class="tagchip11" v-on:click="putcate()"v-model="tag11">사교 / 인맥</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="12" value="차 / 오토바이" class="tagchip12" v-on:click="putcate()" v-model="tag12">차 / 오토바이</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="13" value="사진 / 영상" class="tagchip13" v-on:click="putcate()" v-model="tag13">사진 / 영상</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="14" value="게임 / 오락" class="tagchip14" v-on:click="putcate()" v-model="tag14">게임 / 오락</button>&nbsp;&nbsp;/&nbsp;&nbsp;
<button :id="15" value="반려동물" class="tagchip15" v-on:click="putcate()" v-model="tag15">반려동물</button> -->
<%-- </c:forEach> --%>
</div>
</div>
</div>
<script>
let aoo={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
let boo={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,}
new Vue({
	el:'.tags',
	data:{
		tag0:'요리 / 제조',
		tag1:'아웃도어 / 여행',
		tag2:'운동 / 스포츠',
		tag3:'인문학 / 책 / 글',
		tag4:'업무 / 직무',
		tag5:'외국 / 언어',
		tag6:'문화 / 공연 / 축제',
		tag7:'음악 / 악기',
		tag8:'공예 / 만들기',
		tag9:'댄스 / 무용',
		tag10:'봉사활동',
		tag11:'사교 / 인맥',
		tag12:'차 / 오토바이',
		tag13:'사진 / 영상',
		tag14:'게임 / 오락',
		tag15:'반려동물',
		msg:''
	},
	methods:{
		putcate:function(){
			let m = this.$('button').attr('id')
			aoo[m] += 1
			if(aoo[m]%2!=0 && msg==''){
				this.msg+=this.$('button').attr('value')
			}else if(aoo[m]%2!=0 && msg!=''){
				this.msg= this.msg + ','+ this.$('button').attr('value')
			}else{
				this.msg = this.msg.replace('this.$('button').attr('value')','')
			}
			/* a+=
			b[this.i]!=
			
			if(msg=='' && a%2==1){
				this.msg+='요리 / 제조';
				console.log(msg);
			}else if(msg!='' && a%2==1){
				this.msg+=','+',요리 / 제조';
			}else{
				this.msg=this.msg.replace('요리 / 제조','');
			} */

		}
	}
})
</script>
</body>
</html>