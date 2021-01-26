<template>
<div>
<br><br><br>
<h1>{{title}}</h1><br><br>
    <div class="backstyle">
    <br><br>
    번호 : <b-textarea v-model="dd[0].bbs_id" disabled="true"></b-textarea><br>
    제목 : <b-textarea v-model="dd[0].bbs_title"></b-textarea><br>
    작성일 : <b-textarea  v-model="dd[0].bbs_date" disabled="true"></b-textarea><br>
    </div> 
<br><br>
<b-button variant="outline-success" @click="updatebbs">수정</b-button>
<br><br>
<b-button variant="outline-success" @click="deletebbs">삭제</b-button>
<br><br>
<b-button variant="outline-success" href='/'>목록으로</b-button>
<br><br>

</div>


</template>
<script>
  
export default {
    
    data(){ //=================데이터 선언하는 법
		return{
            title:"Vue Js 게시판 상세보기",
            dd:"",
            bbs: this.$route.query.bbsid,
            aa:[ { "bbs_id": 6, "bbs_title": "제목6", "bbs_date": "2020-01-05T15:00:00.000Z" }]
		}
	},//=================데이터 선언하는 법

    
    watch: {//=================데이터 실시간으로 계속 감지
		
	},//=================데이터 실시간으로 계속 감지 

    mounted() {//=================화면 시작전 함수 정의
 
			this.insertbbs();

	},//=================화면 시작전 함수 정의

    methods: {//=================함수 정의 하는 법
        
    insertbbs() {
        var params = new URLSearchParams();
        params.append('bbsid', this.bbs);
        this.axios.post('http://localhost:4000/bbs/detail',params)
        .then((Resopnse) => {
            console.log(Resopnse);
            this.dd = Resopnse.data;
        }).catch((ex)=>{
            console.log(ex);

        })

    },  
    deletebbs() {
        var a = confirm("삭제하시겠습니까?");
        if(a){

            var params = new URLSearchParams();
            params.append('bbsid', this.bbs);
            this.axios.post('http://localhost:4000/bbs/delete',params)
            .then((Resopnse) => {
                console.log(Resopnse);
                alert('삭제되었습니다.');
                this.$router.push('/');
            }).catch((ex)=>{
                console.log(ex);
                alert('에러가 생겼습니다.');
    
            })
        }
        else{
            return false;
        }

    },  
    updatebbs() {
        var a = confirm("수정건을 저장하시겠습니까 ?");
        if(a){

            var params = new URLSearchParams();
            params.append('bbsid', this.bbs);
            params.append('bbstitle', this.dd[0].bbs_title);
            this.axios.post('http://localhost:4000/bbs/update',params)
            .then((Resopnse) => {
                console.log(Resopnse);
                alert('수정되었습니다.');
                this.$router.push('/');
            }).catch((ex)=>{
                console.log(ex);
                alert('에러가 생겼습니다.');
    
            })
        }
        else{
            return false;
        }

    },  
		
    }//=================함수 정의 하는 법
    
}


</script>

<style>
.backstyle {
  background-color: #7da4ec;
  /* margin: auto;
  border: 3px solid #444444;  */
}
</style>