(this["webpackJsonpsimple-job-board-frontend"]=this["webpackJsonpsimple-job-board-frontend"]||[]).push([[0],{140:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),i=n(19),c=n.n(i),o=(n(50),n(5));var l=function(e){return r.a.createElement("nav",{className:"navbar",role:"navigation","aria-label":"main navigation"},r.a.createElement("div",{className:"navbar-brand"},r.a.createElement(o.b,{to:"/",className:"navbar-item"},e.title)))},s=n(3),d=n(4),u="http://localhost:8080/api/v1",m=function(e){if(!e.ok)throw Error(e.statusText);return e.json()},v=function(e,t){return t?fetch("".concat(u,"/advertisements/").concat(e),{method:"GET",headers:{Authorization:"Bearer ".concat(t)}}).then(m):fetch("".concat(u,"/advertisements/").concat(e)).then(m)},f=function(e,t){return fetch("".concat(u,"/advertisements/").concat(e.id),{method:"POST",headers:{Authorization:"Bearer ".concat(t),"Content-Type":"application/json"},body:JSON.stringify({title:e.title,content:e.content,expirationDate:e.expirationDate,hidden:e.hidden})}).then(m)},p=n(29),h=n(40),E=n.n(h),b={"en-US":{expireIn:"Expire in",days:"days",readMore:"Read more",show:"Show",hide:"Hide",remove:"Remove",edit:"Edit",expirationDate:"Expiration date",apply:"Apply",title:"Title",content:"Content",hidden:"Hidden",save:"Save",username:"username",password:"password",login:"login",invalidUsernameOrPassword:"Invalid username or password"},pl:{expireIn:"Wyga\u015bnie za",days:"dni",readMore:"Czytaj wi\u0119cej",show:"Poka\u017c",hide:"Ukryj",remove:"Usu\u0144",edit:"Edytuj",expirationDate:"Data wyga\u015bni\u0119cia",apply:"Aplikuj",title:"Tytu\u0142",content:"Opis",hidden:"Ukryte",save:"Zapisz",username:"Nazwa u\u017cytkownika",password:"Has\u0142o",login:"zaloguj",invalidUsernameOrPassword:"B\u0142\u0119dny login lub has\u0142o"}};function N(){var e=navigator.language;return e in b?b[e]:b["en-US"]}var g=function(e){var t=N();return r.a.createElement("div",{className:"card ".concat(E.a.advertisement)},r.a.createElement("div",{className:"card-content"},r.a.createElement("div",{className:"media-content"},r.a.createElement("p",{className:"title"},e.advertisement.title)),r.a.createElement("div",{className:"content"},r.a.createElement("p",null,e.advertisement.content.length<150?e.advertisement.content:e.advertisement.content.substring(0,150)+"...")),r.a.createElement("p",{className:"subtitle is-6"},"".concat(t.expireIn," ").concat(function(e){e=new Date(e);var t=new Date,n=e.getTime()-t.getTime();return Math.floor(n/1e3/60/60/24)}(e.advertisement.expirationDate)," ").concat(t.days)),r.a.createElement("div",{className:"buttons"},r.a.createElement(o.b,{className:"button is-primary",to:"advertisements/".concat(e.advertisement.id)},t.readMore),function(){if(e.isLoggedIn)return r.a.createElement(r.a.Fragment,null,r.a.createElement("button",{onClick:function(){return e.handleToggleVisibility(e.advertisement)},className:e.advertisement.hidden?"button is-dark":"button is-light"},e.advertisement.hidden?t.show:t.hide),r.a.createElement("button",{className:"button is-warning",onClick:function(){return e.handleDelete(e.advertisement)}},t.remove),r.a.createElement(o.b,{to:"advertisements/".concat(e.advertisement.id,"/edit")},r.a.createElement("button",{className:"button is-info"},t.edit)))}())))},y=n(2),O=n.n(y),j=n(41),k=n.n(j);var x=function(e){return r.a.createElement(o.b,{to:e.href},r.a.createElement("div",{className:k.a.roundButton},r.a.createElement("p",null,e.content)))};function w(e){var t=Object(a.useState)(e.advertisements),n=Object(d.a)(t,2),i=n[0],c=n[1];Object(s.f)();Object(a.useEffect)((function(){return c(e.advertisements)}),[e.advertisements]);var o=function(t){var n,a;(n=t.id,a=e.token,fetch("".concat(u,"/advertisements/").concat(n),{method:"DELETE",headers:{Authorization:"Bearer ".concat(a)}}).then((function(e){return e}))).then((function(){return c(i.filter((function(e){return e.id!==t.id})))}))},l=function(t){f(Object(p.a)(Object(p.a)({},t),{},{hidden:!t.hidden}),e.token).then((function(){c(i.map((function(e){return e.id===t.id&&(e.hidden=!e.hidden),e})))}))};return r.a.createElement("div",{className:"container"},i.map((function(t){return r.a.createElement(g,{key:t.id,advertisement:t,isLoggedIn:!!e.token,handleDelete:o,handleToggleVisibility:l})})))}w.propeTypes={advertisements:O.a.arrayOf(O.a.shape({id:O.a.number.isRequired,title:O.a.string.isRequired,content:O.a.string.isRequired,creationDate:O.a.string.isRequired,expirationDate:O.a.string.isRequired,hidden:O.a.bool.isRequired})).isRequired,token:O.a.string};var D=w;var T="ADD_TOKEN",S="REMOVE_TOKEN";var _=n(10),C=Object(_.b)((function(e){return{user:e.user}}),(function(e){return{addToken:function(t){return e({type:T,token:t})},removeToken:function(){return e({type:S})}}}))((function(e){var t=Object(a.useState)([]),n=Object(d.a)(t,2),i=n[0],c=n[1];return Object(a.useEffect)((function(){var t;(t=e.user.token,t?fetch("".concat(u,"/advertisements"),{method:"GET",headers:{Authorization:"Bearer ".concat(t)}}).then(m):fetch("".concat(u,"/advertisements")).then(m)).then((function(e){return c(e.content)}))}),[]),r.a.createElement(r.a.Fragment,null,r.a.createElement(D,{advertisements:i,token:e.user.token}),e.user.token?r.a.createElement(x,{content:"+",href:"/advertisements/new"}):null)})),R=n(43),q=n.n(R);n(56);D.propeTypes={advertisement:O.a.shape({id:O.a.number.isRequired,title:O.a.string.isRequired,content:O.a.string.isRequired,creationDate:O.a.string.isRequired,expirationDate:O.a.string.isRequired,hidden:O.a.bool.isRequired}).isRequired};var z=function(e){var t=N();return r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"card ".concat(q.a.advertisement)},r.a.createElement("div",{className:"card-content"},r.a.createElement("div",{className:"media-content"},r.a.createElement("p",{className:"title is-4"},e.advertisement.title)),r.a.createElement("div",{className:"content"},r.a.createElement("p",null,e.advertisement.content.split("\n").map((function(e,t){return r.a.createElement("span",{key:t},e,r.a.createElement("br",null))})))),r.a.createElement("p",{className:"subtitle is-6"},"".concat(t.expirationDate," ").concat(e.advertisement.expirationDate.substring(0,10))),r.a.createElement("div",{className:"buttons"},r.a.createElement("a",{className:"button is-primary",href:"mailto:hr@TestCompany.test"},t.apply)))))};var B=Object(_.b)((function(e){return{user:e.user}}),(function(e){return{addToken:function(t){return e({type:T,token:t})},removeToken:function(){return e({type:S})}}}))((function(e){var t=Object(a.useState)({id:null,title:"",content:"",creationDate:"",expirationDate:"",hidden:null}),n=Object(d.a)(t,2),i=n[0],c=n[1],o=Object(s.g)().id,l=Object(s.f)();return Object(a.useEffect)((function(){v(o,e.user.token).then((function(e){c(e)})).catch((function(e){return l.push("/")}))}),[]),r.a.createElement(r.a.Fragment,null,r.a.createElement(z,{advertisement:i}))})),I=function(e){var t=Object(a.useState)(""),n=Object(d.a)(t,2),i=n[0],c=n[1],o=Object(a.useState)(""),l=Object(d.a)(o,2),s=l[0],u=l[1];return r.a.createElement("div",null,r.a.createElement("form",{action:"",className:"box"},r.a.createElement("h2",{className:"title has-text-centered"},"Login"),r.a.createElement("div",{className:"field"},r.a.createElement("label",{htmlFor:"",className:"label"},"Username"),r.a.createElement("div",{className:"control"},r.a.createElement("input",{onChange:function(e){return c(e.target.value)},value:i,type:"text",placeholder:"e.g. johnDoo12",className:"input",required:!0}))),r.a.createElement("div",{className:"field"},r.a.createElement("label",{htmlFor:"",className:"label"},"Password"),r.a.createElement("div",{className:"control"},r.a.createElement("input",{onChange:function(e){return u(e.target.value)},value:s,type:"password",placeholder:"*********",className:"input",required:!0}))),r.a.createElement("div",{className:"field has-text-centered"},r.a.createElement("button",{onClick:function(t){t.preventDefault(),e.onSubmit(i,s)},type:"submit",className:"button is-primary"},"Login")),e.error?r.a.createElement("div",{className:"notification is-danger has-text-centered"},e.error):null))},A=function(e){var t=Object(s.f)(),n=Object(a.useState)(),i=Object(d.a)(n,2),c=i[0],o=i[1];return r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"columns is-centered"},r.a.createElement("div",{className:"column is-5-tablet is-4-desktop is-3-widescreen"},r.a.createElement(I,{error:c,onSubmit:function(n,a){(function(e,t){return fetch("".concat(u,"/auth"),{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:e,password:t})}).then(m)})(n,a).then((function(n){e.addToken(n.token),o(null),t.push("/")})).catch((function(){return o("invalid username or password")}))}}))))},M=Object(_.b)((function(e){return{user:e.user}}),(function(e){return{addToken:function(t){return e({type:T,token:t})},removeToken:function(){return e({type:S})}}}))(A);var U=function(e){var t=Object(a.useState)(e.title),n=Object(d.a)(t,2),i=n[0],c=n[1],o=Object(a.useState)(e.content),l=Object(d.a)(o,2),s=l[0],u=l[1],m=Object(a.useState)(e.expirationDate),v=Object(d.a)(m,2),f=v[0],p=v[1],h=Object(a.useState)(e.hidden),E=Object(d.a)(h,2),b=E[0],N=E[1];return Object(a.useEffect)((function(){c(e.title),u(e.content),p(e.expirationDate),N(e.hidden)}),[e.id]),r.a.createElement("form",null,r.a.createElement("div",{className:"field is-horizontal"},r.a.createElement("div",{className:"field-label is-normal"},r.a.createElement("label",{className:"label"},"Title")),r.a.createElement("div",{className:"field-body"},r.a.createElement("div",{className:"field"},r.a.createElement("p",{className:"control"},r.a.createElement("input",{className:"input",onChange:function(e){return c(e.target.value)},value:i,type:"text",placeholder:"Title"}))))),r.a.createElement("div",{className:"field is-horizontal"},r.a.createElement("div",{className:"field-label is-normal"},r.a.createElement("label",{className:"label"},"Content")),r.a.createElement("div",{className:"field-body"},r.a.createElement("div",{className:"field"},r.a.createElement("p",{className:"control"},r.a.createElement("textarea",{className:"textarea",onChange:function(e){return u(e.target.value)},value:s,placeholder:"Your job advertisment"}))))),r.a.createElement("div",{className:"field is-horizontal"},r.a.createElement("div",{className:"field-label is-normal"},r.a.createElement("label",{className:"label"},"Expiration date")),r.a.createElement("div",{className:"field-body"},r.a.createElement("div",{className:"field"},r.a.createElement("p",{className:"control"},r.a.createElement("input",{type:"datetime-local",className:"input",value:f,onChange:function(e){return p(e.target.value)}}))))),r.a.createElement("div",{className:"field is-horizontal"},r.a.createElement("div",{className:"field-label is-normal"},r.a.createElement("label",{className:"label"},"Hidden")),r.a.createElement("div",{className:"field-body"},r.a.createElement("div",{className:"field"},r.a.createElement("p",{className:"control"},r.a.createElement("input",{type:"checkbox",className:"checkbox",onChange:function(e){return N(e.target.checked)}}))))),r.a.createElement("div",{className:"field is-horizontal"},r.a.createElement("div",{className:"field-label"}),r.a.createElement("div",{className:"field-body"},r.a.createElement("div",{className:"field"},r.a.createElement("div",{className:"control"},r.a.createElement("button",{type:"submit",onClick:function(t){t.preventDefault(),e.onSubmit(i,s,f,b)},className:"button is-primary"},"Save"))))))},P=function(e){var t=Object(s.f)();return r.a.createElement("div",{className:"container"},r.a.createElement(U,{onSubmit:function(n,a,r,i){var c,o;(c={title:n,content:a,expirationDate:r,hidden:i},o=e.user.token,fetch("".concat(u,"/advertisements"),{method:"POST",headers:{Authorization:"Bearer ".concat(o),"Content-Type":"application/json"},body:JSON.stringify({title:c.title,content:c.content,expirationDate:c.expirationDate,hidden:c.hidden})}).then(m)).then((function(e){return t.push("/advertisements/".concat(e.id))}))},title:"",content:"",expirationDate:"",hidden:!1}))},F=Object(_.b)((function(e){return{user:e.user}}),(function(e){return{addToken:function(t){return e({type:T,token:t})},removeToken:function(){return e({type:S})}}}))(P);var J=Object(_.b)((function(e){return{user:e.user}}),(function(e){return{addToken:function(t){return e({type:T,token:t})},removeToken:function(){return e({type:S})}}}))((function(e){var t=Object(s.g)().id,n=Object(s.f)(),i=Object(a.useState)({id:null,title:"",content:"",creationDate:"",expirationDate:"",hidden:null}),c=Object(d.a)(i,2),o=c[0],l=c[1];return Object(a.useEffect)((function(){v(t,e.user.token).then((function(e){l(e)})).catch((function(e){return n.push("/advertisements/")}))}),[]),r.a.createElement("div",{className:"container"},r.a.createElement(U,{id:o.id,title:o.title,content:o.content,expirationDate:o.expirationDate,hidden:o.hidden,onSubmit:function(a,r,i,c){f({id:t,title:a,content:r,expirationDate:i,hidden:c},e.user.token).then((function(e){return n.push("/advertisements/".concat(e.id))}))}}))}));var L=function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(o.a,null,r.a.createElement(l,{title:"Simple-Job-Board"}),r.a.createElement(s.c,null,r.a.createElement(s.a,{excat:!0,path:"/advertisements/new"},r.a.createElement(F,null)),r.a.createElement(s.a,{excat:!0,path:"/advertisements/:id/edit"},r.a.createElement(J,null)),r.a.createElement(s.a,{excat:!0,path:"/advertisements/:id"},r.a.createElement(B,null)),r.a.createElement(s.a,{excat:!0,path:"/login"},r.a.createElement(M,null)),r.a.createElement(s.a,{excat:!0,path:"/"},r.a.createElement(C,null)))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var H=n(13),V=Object(H.c)({user:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"",t=arguments.length>1?arguments[1]:void 0;switch(t.type){case T:return{token:t.token};case S:return{token:null};default:return e}}}),W=n(44),X=n.n(W);var G=function(e){var t="undefined"!==typeof window&&window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__||H.d;return Object(H.e)(V,e,t(Object(H.a)(X()())))}();c.a.render(r.a.createElement(_.a,{store:G},r.a.createElement(r.a.StrictMode,null,r.a.createElement(L,null))),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))},40:function(e,t,n){e.exports={advertisement:"advertisementItem_advertisement__3uHEI"}},41:function(e,t,n){e.exports={roundButton:"roundButton_roundButton__XdrwM",spinAround:"roundButton_spinAround__W-YdM"}},43:function(e,t,n){e.exports={advertisement:"advertisementView_advertisement__3IWjw"}},45:function(e,t,n){e.exports=n(140)},50:function(e,t,n){}},[[45,1,2]]]);
//# sourceMappingURL=main.97412e99.chunk.js.map