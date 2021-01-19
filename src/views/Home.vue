<template>
    <div>
        
        <h1>Home Page</h1>
        <br>
        <b-button variant="outline-success" @click="PlusData">Plus</b-button>
        <br><br>

        <div>
			<table class="aaaaa">
				<colgroup>
					<col width="6%" />
					<col width="40%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>아이디</th>
					<th>날짜</th>
				</tr>
				<tr :key="i" v-for="(row, i) in options" >
					<td>{{row.num}}</td>
					<td class="txt_left"><a href="javascript:;">{{row.titime}}</a></td>
					<td>{{row.writer}}</td>
					<td>{{row.time}}</td>
				</tr>
			</table>
        </div>
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
		}
	},//=================데이터 선언하는 법

    
    //watch: {//=================데이터 실시간으로 계속 감지
		
		//num(){   //변수명으로 만들기!
		//	console.log(this.num);
		//}
		
	//},//=================데이터 실시간으로 계속 감지 


    methods: {//=================함수 정의 하는 법
		
		getData(){
			alert(this.num);
		},
		setData(){
            this.num = "gogogog";
            console.log("1111111111111");
        },
		PlusData(){
            this.options.push({num: "7", titime: "AAAA", writer: "대전", time:"2000-01-01"});
            console.log("1111111111111");
            
        },
        
		
		
	}//=================함수 정의 하는 법
}
</script>
<style>
.aaaaa {
  /* background-color: chartreuse; */
  margin: auto;
}
</style>