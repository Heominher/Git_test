<template>
    <div>
        
        <h1>Home Page</h1>
        <br>
        <b-button variant="outline-success" @click="PlusData">Plus</b-button>
        &nspn <b-button variant="outline-success" @click="PushData">Push</b-button>
        <br><br>
        <a href="/test"><b-button variant="outline-success">홈페이지</b-button></a>
		<br><br>
		<input class="inputStyle" placeholder='NO 입력하기..' type="text" v-model="n1"/>
		<input class="inputStyle" placeholder='제목 입력하기..' type="text" v-model="n2"/>
		<!-- <input class="inputStyle" placeholder='날짜 입력하기..' type="text" v-model="n3"/> -->
		<br><br>
		<b-button pill variant="outline-danger" @click="insertbbs">추가하기</b-button>
		<br><br>
        <div>
			<table class="aaaaa">
				<colgroup>
					<col width="6%" />
					<col width="40%" />
					<col width="10%" />
				</colgroup>
				<tr class="trtdStyle">
					<th class="trtdStyle fontStyle">no</th>
					<th class="trtdStyle fontStyle">제목</th>
					<th class="trtdStyle fontStyle">작성일</th>
				</tr>
				<tr :key="i" v-for="(row, i) in paginatedData" class="trtdStyle">
					<td class="trtdStyle fontStyle">{{row.bbs_id}}</td>
					<!-- <td class="txt_left"><a href="/bbs">{{row.bbs_title}}</a></td> -->
					<td class="txt_left trtdStyle fontStyle"><a :href="'/bbs?bbsid=' + row.bbs_id">{{row.bbs_title}}</a></td>
					<td class="trtdStyle fontStyle">{{row.bbs_date.substring(0,10)}}</td>
				</tr>
			</table>
        </div>
			<b-button variant="outline-success" @click="fnGetList">Get</b-button><br><br>
			<b-button variant="outline-success" @click="startPage">처음</b-button>
			<button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
				이전
			</button>
			<!-- <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span> -->
			<ul class="ulstyle">
				<li v-for="row in pageCount" v-bind:key="row"><a @click="thisPage(row)">{{row}}</a></li>
			</ul>
			<button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
				다음
			</button>
			<b-button variant="outline-success" @click="finshPage">끝</b-button>
    </div>
</template>
<script>


export default {
    data(){ //=================데이터 선언하는 법
		return{
			num: "zzzz",
			num2: "12345",
			options:[
				{num: "1", titime: "SU", writer: "서울", time:"2020-12-12"},
				{num: "2", titime: "SUI", writer: "부산", time:"2020-12-13"},
				{num: "3", titime: "SUIO", writer: "울산", time:"2020-12-14"},
				{num: "4", titime: "SUIOP", writer: "태안", time:"2020-12-15"},
				{num: "5", titime: "Q", writer: "대구", time:"2020-12-16"},
				{num: "6", titime: "QW", writer: "전주", time:"2020-12-17"},
			],
			n1:"",
			n2:"",
			n3:"",
			n4:"",
			list:"",
			//================페이징 변수==============//
			pageSize: 5, //페이지 한개당 게시물 수 
			pageNum: 0, //시작 페이지
			totalPage: 0,

		}
	},//=================데이터 선언하는 법


	//watch: {//=================데이터 실시간으로 계속 감지
		
		//num(){   //변수명으로 만들기!
		//	console.log(this.num);
		//}
		
	//},//=================데이터 실시간으로 계속 감지 
	
	mounted() {//=================화면 시작전 함수 정의
			this.fnGetList();
	},//=================화면 시작전 함수 정의


methods: {//=================함수 정의 하는 법
	getData(){
		alert(this.num);
	},
	setData(){
		this.num = "gogogog";
		console.log("1111111111111");
	},
	PlusData(){
		this.list.push({bbs_id: "7", bbs_title: "AAAA", bbs_date: "2000-01-01"});
		console.log("1111111111111");   
	},
	PushData(){
		this.list.push({bbs_id: this.n1, bbs_title: this.n2, bbs_date: this.n3});
		this.n1 = "";
		this.n2 = "";
		this.n3 = "";
	},
	fnGetList() { //데이터 가져오기 함수
		this.axios.get('/users') 
		.then(res => { // 불러온 값을 Console에 뿌려줍니다. 
		console.log(res.data) ;
		this.list = res.data;
		console.log(this.list.length);
		})
	},
	insertbbs() {
		var params = new URLSearchParams();
		params.append('n1', this.n1);
		params.append('n2', this.n2);
		params.append('n3', this.n3);
		this.axios.post('/bbs/insert',params)
		.then((Resopnse) => {
			console.log(Resopnse);
			alert('추가하였습니다');
			this.n1 = "";
			this.n2 = "";
			this.n3 = "";
			this.fnGetList();
		}).catch((ex)=>{
			console.log(ex);
			alert('실패했습니다');
			this.n1 = "";
			this.n2 = "";
			this.n3 = "";
		})
	},
	nextPage () {
		this.pageNum += 1;
	},
	prevPage () {
		this.pageNum -= 1;
	},
	startPage () {
		this.pageNum = 0;
	},
	finshPage () {
		this.pageNum = this.pageCount-1;
	},
	thisPage (num) {
		this.pageNum = num-1;
	},
	
},//=================함수 정의 하는 법
	
	
computed: { //=================연산 정의 하는 법

	pageCount () {
      let listLeng = this.list.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.list.slice(start, end);
    }
  

},//=================연산 정의 하는 법


}
</script>
<style>
.aaaaa {
  background-color: #e0ffc2;
  margin: auto;
  border: 3px solid #444444; 
}
.trtdStyle {
  border: 3px solid #444444; 
}
.fontStyle {
  font-size: 20px;
}
.btnStyle {
  size: 300px;
}
.inputStyle {
  background-color: blanchedalmond;
  margin: 24px;
  height: 56px;
  width: 330px;
  font-size: 23px;
  border-radius: 10px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
.ulstyle{
	list-style:none;
	display : inline-block;
	padding-left: 0%;
}
.ulstyle li{
	display:inline-flex;
}
.ulstyle li a{ 
	float:left;
	padding:4px;
	margin-right:3px;
	width:15px;
	color:#000;
	font:bold 12px tahoma;
	border:1px solid #eee;
	text-align:center;
	text-decoration:none;
}
.ulstyle li a:hover, .ulstyle li a:focus{
	color:#fff;
	border:1px solid #f40;
	background-color:#f40;
}
</style>