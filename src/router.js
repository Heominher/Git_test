import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/Home';
import Numpage from './views/Numpage';
import Bbspage from './views/Bbs';

Vue.use(VueRouter);

const router = new VueRouter({

    mode: "history",
    routes: [{
            path: "/",
            component: Home
        },
        {
            path: "/num",
            component: Numpage
        },
        {
            path: "/bbs",
            component: Bbspage
        },
    ]

});

console.log("1111111111111");

export default router;