<template>
<div>
    <div class="back">
        <br><br>
        <div class="topmenu__item">
            <a class="Vlt-topmenu__link" href="/">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test One
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link" href="/test">
                <div class="Vlt-topmenu__link-content">
                    <span ref="aa" @click="aaaa()" class="text1">
                    Test Two
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link" href="/num">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Three
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link1" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link1" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link1" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link1" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link2" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link2" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link2" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        <div class="topmenu__item">
            <a class="Vlt-topmenu__link2" href="/example">
                <div class="Vlt-topmenu__link-content">
                    <span class="text1">
                    Test Fore
                    </span><br><br>
                    <span class="text2">
                    Industry acknowledgements of excellence.
                    </span>
                </div>
            </a>
        </div>

        
    </div>
    
    <span class="tt22 up-on-scroll">
    123423523
    </span>
    <span class="tt11 up-on-scroll1">
    123423523
    </span>


</div>
</template>
<script>


// new Vue({ 
//     el:'#vue-app', 
//     data: { 
//         output: '' 
//     }, 
//     methods: { 
//         readRefs: function () { 
//             console.log(this.$refs); 
//             this.output = this.$refs.input.value; 
//         } 
//     } 

// });




// this.$refs.btn
export default {

data(){ //=================데이터 선언하는 법
    return{
       message: 'Hello World!',

    }
},//=================데이터 선언하는 법

methods: {//=================함수 정의 하는 법

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
                elem.style.transform = 'translateX(-500px)';
            } else {
                elem.style.opacity = "1";
                elem.style.transform = 'translateX(0px)';
                elem.style.background = 'red';
            }
            
        })
    },
    
    handleScroll1() {
        const elems = document.querySelectorAll('.up-on-scroll1');
        elems.forEach(elem => {
            if (this.isElementUnderBottom(elem, -20)) {
                elem.style.opacity = "0";
                elem.style.transform = 'translateY(300px)';
            } else {
                elem.style.opacity = "1";
                elem.style.transform = 'translateY(0px)';
                elem.style.background = 'yellow';
            }
            
        })
    },

},//=================함수 정의 하는 법

created () {
    window.addEventListener('scroll', this.handleScroll);
    window.addEventListener('scroll', this.handleScroll1);
  },
//   destroyed () {
//     window.removeEventListener('scroll', this.handleScroll);
//   }
    
}
</script>
<style>
@keyframes slidein {
  from {top:10px;}
  to {top:300px;}
}


.back{background-color : black; max-width: 100%; height: 100rem; display: inline-block;}
.topmenu__item{display: inline-block; opacity: 1; max-width: 20%; margin-left:1%; margin-bottom: 2%;}
.Vlt-topmenu__link{background-image : linear-gradient(90deg,#881fff,#80aaf6 35%,#7fc8f5); border-radius:2rem; position: relative; color:white; display: block;}
.Vlt-topmenu__link1{background-image : linear-gradient(90deg,#53b66a,#dd75d4 35%,#d1ff05); border-radius:2rem; position: relative; color:white; display: block;}
.Vlt-topmenu__link2{background-image : linear-gradient(90deg,#ffa319,#b5bbf1 35%,#ff0037); border-radius:2rem; position: relative; color:white; display: block;}
.Vlt-topmenu__link-content{background-color : black; border-radius:2rem; display:flex; margin: -0.1rem; min-height:17.2rem; padding:3.3rem 4rem; transition-duration: 0.3s; flex-direction:column; -webkit-box-direction:normal; -webkit-box-pack:center;}
.Vlt-topmenu__link-content:hover{transform: translate(-10px, -5px);}
.text1{font-size : 2rem;font-weight:500;letter-spacing:-0.05rem; line-height: 2.4rem; text-align:start;}
.text2{font-size : 1.2rem;font-weight:400;letter-spacing:.025rem; line-height: 1.6rem; text-align:start;}


.up-on-scroll {margin-top: 0px; transition: transform 1.7s, opacity 1s;}
.up-on-scroll1 {margin-top: 0px; transition: transform 1.7s, opacity 1s;}
.tt22{position: absolute; bottom: -50%;position:absolute; color: white; bottom: -50; left: 30%; font-size: 2rem;}
.tt11{position: absolute; bottom: -50%;position:absolute; color: white; bottom: -50; left: 70%; font-size: 2rem;}
</style>