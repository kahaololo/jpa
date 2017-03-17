/**
 * Created by skokhanenko on 28.02.2017.
 */
'use strict';

var currentTag = null;
var routes = {};

function mount(tag, options) {
    currentTag && currentTag.unmount(true);
    currentTag = riot.mount('#content', tag, options)[0];
}

function handler(collection, id, action) {
    var fn = routes[collection || 'welcome'];
    fn ? fn(id, action) : mount('not-found-page');
}

route(handler);