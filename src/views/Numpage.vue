<template>
    <div>
        <h1>Heoll Numpage!! {{num}}</h1>
        <input type="text" v-model="num"/>
        
        <br><br><b-button variant="outline-success" @click="getData">GetData</b-button>
        <br><br><b-button variant="outline-success" @click="setKakaoIamge">set Kakao</b-button>
        <br><br><b-button variant="outline-success" @click="resetIamge">resetIamge</b-button><br><br>
        
        
        <b-container fluid class="p-4 bg-dark">
            <b-row>
                <b-col>
                <b-img thumbnail fluid v-bind:style="{width: width, height: heigth}" :src="img1" alt="Image 1"></b-img>
                </b-col>
                <b-col>
                <b-img thumbnail fluid v-bind:style="{width: width, height: heigth}" :src="img2" alt="Image 2"></b-img>
                </b-col>
                <b-col>
                <b-img thumbnail fluid v-bind:style="{width: width, height: heigth}"  :src="img3" alt="Image 3"></b-img>
                </b-col>
            </b-row>
        </b-container>

 </div>

</template>
<script>
export default {


 data(){ //=================데이터 선언하는 법
		return{
            num: "12345",
            img1: "https://picsum.photos/250/250/?image=54",
            img2: "https://picsum.photos/250/250/?image=58",
            img3: "https://picsum.photos/250/250/?image=59",

            kaimg1: "https://image.edaily.co.kr/images/Photo/files/NP/S/2020/11/PS20110800291.jpg",
            kaimg2: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMEHugLEvV1-KlDk5bJsHzIVtSbNg6d-kG7Q&usqp=CAU",
            kaimg3: "https://www.bloter.net/wp-content/uploads/2016/07/kakaohair.jpg",

            width: "240px",
            heigth: "222px",


		}
    },//=================데이터 선언하는 법
    

    methods: {//=================함수 정의 하는 법
		
		getData(){
			alert(this.num);
		},
		setData(){
			this.num = "gogogog";
        },
        setKakaoIamge(){
            this.img1 = this.kaimg1;
            this.img2 = this.kaimg2;
            this.img3 = this.kaimg3;
        },
        resetIamge(){
            this.img1 = "https://picsum.photos/250/250/?image=54";
            this.img2 = "https://picsum.photos/250/250/?image=58";
            this.img3 = "https://picsum.photos/250/250/?image=59";
		},
		
		
	},//=================함수 정의 하는 법

    
};
</script>