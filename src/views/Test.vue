<template>
    <div>
        <div class="li2div" @click="testtest" v-bind:style="{ display: test111}">
            <div id="closebtn">
                <img src="https://www.vizensoft.com/img/close_btn.png" alt="닫기">
            </div>
            <div class="hiddenmenu">
                <ul>
                    <li class="li2">
                        <a href="/">
                            <img src="https://www.vizensoft.com/img/all_icon01.png" alt="홈페이지제작">
                            <p>MIANPAGE</p>
                            <p>게시판</p>
                        </a>
                    </li>
                    <li class="li2">
                        <a href="/example">
                            <img src="https://www.vizensoft.com/img/all_icon02.png" alt="모바일">
                            <p>MOBILE</p>
                            <p>에니메이션 예제</p>
                        </a>
                    </li>
                    <li class="li2">
                        <a href="/num">
                            <img src="https://www.vizensoft.com/img/all_icon08.png" alt="쇼핑몰">
                            <p>Shopping Mall</p>
                            <p>기초 예제</p>
                        </a>
                    </li>
                    <li class="li2">
                        <a href="https://bootstrap-vue.org/docs/components/nav">
                            <img src="https://www.vizensoft.com/img/all_icon03.png" alt="디자인">
                            <p>DESIGN</p>
                            <p>디자인</p>
                        </a>
                    </li>
                    <li class="li2">
                        <a href="https://www.naver.com/">
                            <img src="https://www.vizensoft.com/img/all_icon04.png" alt="소프트웨어">
                            <p>SOFTWARE</p>
                            <p>소프트웨어</p>
                        </a>
                    </li>
                    <li class="li2">
                        <a href="/example2">
                            <img src="https://www.vizensoft.com/img/all_icon05.png" alt="견적&amp;상담요청">
                            <p>CONTACTUS</p>
                            <p>CSS&amp;연습중</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div id="divherdeer">
            <h1 class="mainlog"><a href="/"><img src="https://www.vizensoft.com/img/logo2.png"/></a></h1>

            <div class="div1">
                <div class="leftmenuicon" @click="showsidemenubar">
                    <a><img src="https://www.vizensoft.com/img/all_menu_wver.png"/></a>
                </div>
                <div class="aa">
                    <ul>
                        <a><li class="li1">PORTFOLIO <span class="haver">포트폴리오</span></li></a>
                        <a href="https://vuejsexamples.com/tag/chat/"><li class="li1">ABOUT <span class="haver">예제 컴포넌트</span></li></a>
                        <a href="/example2"><li class="li1">CSS EXAMPLE<span class="haver">연습&CSS</span></li></a>
                        <a href="https://www.naver.com/"><li class="li1">NAVER <span class="haver">네이버</span></li></a>
                        <a href="https://bootstrap-vue.org/docs/components/nav"><li class="li1">DESIGN <span class="haver">디자인</span></li></a>
                        <a href="/num"><li class="li1">SHOPPING MALL <span class="haver">기본예제</span></li></a>
                        <a href="/example"><li class="li1">MOBILE <span class="haver">에니메이션 예제</span></li></a>
                        <a href="/"><li class="li1">HOMEPAGE <span class="haver">홈페이지</span></li></a>
                        
                    </ul>
                </div>
            </div>
        </div>
        <div class="div2">
            <ul>
                <li>
                    <img class="potostyle" src="https://www.vizensoft.com/img/sub_title08.png"/>
                    <!-- <img class="potostyle" src="../image/loger.png"/> -->
                    <p>급변하는 시장에서 <strong>통찰력</strong> 가지고<br> 
                    <strong>누구나 쉽게</strong> 이용 가능한 <strong>쇼핑몰을 제공</strong> 해드리겠습니다.
                    </p>
                </li>
                <li>
                    <img class="potostyle1" src="https://www.vizensoft.com/img/sub_visual08.gif"/>
                </li>
            </ul>
        </div>


        <div class="seconddic">
            <div class="tempsyle1">
                    <div class="li1style">
                        <img class="li1stylepoto1" src="https://www.vizensoft.com/img/shopping01_img01_01.png"/>
                        <img class="li1stylepoto2" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                        <img class="li1stylepoto3" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                    </div>
                    <div class="li2style up-on-scroll">
                        <ul>
                            <li>
                                <p class="txt1">허민혁의 직관적인 INTERFACE</p><br><br><br> 
                            </li>
                            <li>
                                <h1 class="txt2">Intuitive<br>Interface</h1><br>
                                <!-- <h1 class="txt2">Interface</h1> -->
                            </li>
                            <li>
                                <p class="txt3">This design makes it easy and easy for anyone to access
                                <br>the shopping mall's homepage by making it their first priority.</p>
                            </li>

                        </ul>
                    </div>
            </div>
            <div class="tempsyle2">
                    <div class="li3style up-on-scroll">
                        <ul>
                            <li>
                                <p class="txt4">허민혁의 손 쉬운 관리</p><br><br><br> 
                            </li>
                            <li>
                                <h1 class="txt5">Convenient<br>Management</h1><br>
                                <!-- <h1 class="txt2">Interface</h1> -->
                            </li>
                            <li>
                                <p class="txt6">Even if you've never managed a shopping mall before,
                                <br>you can manage the shopping mall's homepage without difficulty</p>
                            </li>

                        </ul>
                    </div>
                    <div class="li4style">
                        <img class="li1stylepoto4" src="https://www.vizensoft.com/img/shopping01_img01_01.png"/>
                        <img class="li1stylepoto5" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                        <img class="li1stylepoto6" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                    </div>
            </div>
            <div class="tempsyle3">
                <div class="li5style">
                        <img class="li1stylepoto7" src="https://www.vizensoft.com/img/shopping01_img01_01.png"/>
                        <img class="li1stylepoto8" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                        <img class="li1stylepoto9" src="https://www.vizensoft.com/img/shopping01_img01_02.png"/>
                    </div>
                    <div class="li6style up-on-scroll">
                        <ul>
                            <li>
                                <p class="txt7">매출통계를 한눈에</p><br><br><br> 
                            </li>
                            <li>
                                <h1 class="txt8">Statistical<br>System</h1><br>
                                <!-- <h1 class="txt2">Interface</h1> -->
                            </li>
                            <li>
                                <p class="txt9">We provide various time-based statistics,
                                <br>from basic sales statistics to product and customer statistics.</p>
                            </li>

                        </ul>
                    </div>
            </div>
        </div>
        





    </div>
</template>

<script>
export default {

data(){ //=================데이터 선언하는 법
    return{
        num: "12345",
        test111: "none",
        test22: "all 3s",
        // test22: "red",
        white:"white",
    }
},//=================데이터 선언하는 법

methods: {//=================함수 정의 하는 법
    testtest(){
			this.test111="none";
		},
    showsidemenubar(){
            this.test111="";
        },
        
    isElementUnderBottom(elem, triggerDiff) {
        const { top } = elem.getBoundingClientRect();
        const { innerHeight } = window;
        return top > innerHeight + (triggerDiff || 0);
    },

    handleScroll() {
        const elems = document.querySelectorAll('.up-on-scroll');
        elems.forEach(elem => {
            if (this.isElementUnderBottom(elem, -20)) {
                elem.style.opacity = "0";
                elem.style.transform = 'translateY(300px)';
            } else {
                elem.style.opacity = "1";
                elem.style.transform = 'translate(0px)';
            }
            
        })
    },
},//=================함수 정의 하는 법

    created () {
    window.addEventListener('scroll', this.handleScroll);
  },

}
</script>

<style>
/* #app { */
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px; */
/* } */

#divherdeer{
    width: 100%;
    height: 110px;
    position: absolute;
    z-index: 1;
    padding: 0 1.15%;
    box-sizing: border-box;
    background-color: #ffc4c4;
}
.mainlog{
    float: left;
    margin: 1rem 1rem;
 }
.hiddenmenu{
    position: absolute;
    top: 40%;
    width: 100%;
    text-align: center;
 }
.haver{
    display: none;
    position : absolute;
    top : 72px;
 }
.li1:hover span.haver{
    display: block;
}
.potostyle{width: 61rem; height: 6.5rem; max-height: 100%; max-width: 100%;}
.li1:hover{
    /* background-color: yellowgreen; */
    border-bottom : 3.5px solid #222;
    color : #222;
    margin-bottom: 10%;
    transition: all 1s;
    -webkit-transform: rotate(360deg);
  transform: rotate(360deg);
 }
.potostyle1{width: 48rem; height: 26.5rem; display: inline; max-width: 100%; max-height: 100%;}
.div1{
    /* background-color: #FFEB3B; */
    padding: 0 2.15%;
    box-sizing: border-box;
    margin-top: 2%;
    float: right;
    overflow: hidden;
    
 }
 img{
     text-decoration : none;
 }
.aa{
    overflow: hidden;
 }
.div2{background-color: #ffc4c4;margin-bottom: 105px;padding: 0 .15%;box-sizing: border-box;padding-top: 260px;padding-bottom: 210px;}
 .li2 p{
     color:white;
     /* text-decoration : none; */
     

 }
 .li1{
     float: right;
     padding: 0 15px;
     list-style: none;
     font-size: 21px;
     color : white;
     font-weight: 600;
     transition-duration: 1s;
 }
 .li2{
     display : inline-grid;
     padding: 0 50px;
     list-style: none;
     font-size: 18px;
     color : white;
     font-weight: 600;

 }
 .li2 a img{
     width: 12rem;
     height: 12rem;
 }
 .li2div{
     position : fixed;
     width: 100%;
     height: 100%;
     background-color: rgb(0, 0, 0);
     z-index: 10;
     padding-top: 16rem;
     opacity: 0.87;
     pointer-events: auto;
     /* transition: all 1s; */
     transition-duration: 2s;
 }
#closebtn{
    transition-duration: 2s;
     position : absolute;
     top : 50px;
     right : 2%;
     cursor : pointer;
 }
#closebtn:hover{
    top : 70px;
    transition: all 1s;
 }
.li2 a:hover{
    outline-color: yellow;
    transition: all 2s;
    text-decoration: none;
    /* background-color: yellow; */
    transform: scale( 1.3 );
    
} 
li{
    list-style: none;
 }
a{
    cursor: pointer;
    transition-duration: 2s;
 }
.leftmenuicon{
     position: fixed;
     margin-top: 2px;
     right: 0.5%;
     z-index: 80;
 }
.div2 ul li{
     display: table-cell;
     width: 50%;
     vertical-align: middle;
 }
.div2 ul li p{
    margin-left : 9%;
    margin-top : 4%;
    color: white;
    font-weight: 300;
    word-break : keep-all;
    padding-right : 5.7%;
    font-size : 30px;
    text-align: left;
    box-sizing : border-box;
    letter-spacing : -0.05em;
    
    animation-duration: 3s;
    animation-name: slidein; 
}
@keyframes slidein {
  from {
    margin-left: 100%;
    width: 300%
  }
  to {
    margin-left: 9%;
    width: 100%;
  }
}

.seconddic{ width: 100%; height: 100%;}

.tempsyle1{ width: 100%; height: 50rem; display: flex;}
.li1style{ background-color: khaki; width: 50%; height: 100%;}
.li1stylepoto1{ max-height: 108%; max-width: 100%; z-index: 1;}
.li1stylepoto2{ max-height: 100%; max-width: 100%; z-index: 2; position: absolute; left: 15%;}
.li1stylepoto3{ max-height: 100%; max-width: 100%; height: 66%; padding-top: 28rem; z-index: 3; position: absolute; left: 15%;}
.li2style{ background-color: rgb(255, 255, 255); width: 50%; height: 100%; padding-top:9rem; padding-right:12rem;}
.txt1{  font-size: 26px; font-weight: 500; color:blue; margin-left:9rem; float: left;}
.txt2{ line-height:85%; font-size: 7rem; text-align: left; margin-left: 9rem; font-weight: 700; color:black}
.txt3{ font-size: 23px; text-align: left; margin-left: 9rem; color:black}

.tempsyle2{ width: 100%; height: 50rem; display: flex;}
.li1stylepoto4{ max-height: 107.5%; max-width: 100%; z-index: 1;}
.li1stylepoto5{ max-height: 100%; max-width: 100%; z-index: 2; position: absolute; left: 62%; transition-duration: 2s;}
.li1stylepoto5:hover{ max-height: 200%; transform: rotate(45deg);}
.li1stylepoto6{ max-height: 100%; max-width: 100%; height: 66%; padding-top: 28rem; z-index: 3; position: absolute; right: 25%;}
.li3style{ background-color: rgb(255, 255, 255); width: 50%; height: 100%; padding-top:9rem;}
.li4style{ background-color: rgb(221, 59, 59); width: 50%; height: 100%;}
.txt4{  font-size: 26px; font-weight: 500; color:blue; margin-left:5rem; float: left;}
.txt5{ line-height:85%; font-size: 7rem; text-align: left; margin-left: 5rem; font-weight: 700; color:black}
.txt6{ font-size: 23px; text-align: left; margin-left: 5rem; color:black}


.tempsyle3{ width: 100%; height: 50rem; display: flex;}
.li5style{ background-color: rgb(0, 0, 0); width: 50%; height: 100%;}
.li1stylepoto7{ max-height: 108%; max-width: 100%; z-index: 1;}
.li1stylepoto8{ max-height: 100%; max-width: 100%; z-index: 2; position: absolute; left: 15%;}
.li1stylepoto9{ max-height: 100%; max-width: 100%; height: 66%; padding-top: 28rem; z-index: 3; position: absolute; left: 15%;}
.li6style{ background-color: rgb(255, 255, 255); width: 50%; height: 100%; padding-top:9rem; padding-right:12rem;}
.txt7{  font-size: 26px; font-weight: 500; color:blue; margin-left:9rem; float: left;}
.txt8{ line-height:85%; font-size: 7rem; text-align: left; margin-left: 9rem; font-weight: 700; color:black}
.txt9{ font-size: 23px; text-align: left; margin-left: 9rem; color:black}


.up-on-scroll {margin-top: 0px; transition: transform 0.7s, opacity 1s;}




</style>