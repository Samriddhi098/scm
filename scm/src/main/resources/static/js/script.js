console.log("script loaded");
let currentTheme=getTheme();
let oldTheme=currentTheme;
document.addEventListener('DOMContentLoaded',() =>{
    changeTheme();
})
// console.log(currentTheme)
// //todo


function changeTheme(){

    changePageTheme(currentTheme,"");
    //set the Listener to chnge theme button
  const changethemebutton =  document.querySelector('#theme_change_button');

    changethemebutton.addEventListener("click",(event)=>{
        let oldTheme=currentTheme;
        console.log("change theme button clicked");   
    if(currentTheme==="dark"){
//light the theme
currentTheme="light";
    }else{
        currentTheme="dark";
    }
    console.log(currentTheme);
changePageTheme(currentTheme,oldTheme);
});
}
//set theme to localstorage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}
function getTheme(){
    let theme=localStorage.getItem("theme");
    if(theme)
        return theme;
        else return "light";
    }
 function changePageTheme(theme,oldtheme){
    //update in localstorage
    // const oldTheme=currentTheme;
    setTheme(currentTheme);
    //remove the old one
  
    document.querySelector('html').classList.remove(oldTheme);
    //set the new
    document.querySelector('html').classList.add(theme);
  // change the text
  document
  .querySelector('#theme_change_button')
  .querySelector('span').textContent= 
  theme =='light'?'dark':'Light';
}