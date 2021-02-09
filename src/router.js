import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/Home';
import Numpage from './views/Numpage';
import Bbspage from './views/Bbs';
import testPage from './views/Test';
import Transform from './views/Transform';
import example from './views/example';

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
        {
            path: "/test",
            component: testPage
        },
        {
            path: "/example",
            component: Transform
        },
        {
            path: "/example2",
            component: example
        },
    ]
});

console.log("1111111111111");

export default router;