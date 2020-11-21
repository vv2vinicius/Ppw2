
toggleAside = function(event) {
    event.preventDefault();
    if(isMobile()){
        if(document.body.classList.contains('aside-mobile-open')){
            document.body.classList.remove('aside-mobile-open');
        } else {
            document.body.classList.add('aside-mobile-open');
        }
    } else {
        if(document.body.classList.contains('aside-open')){
            document.body.classList.remove('aside-open');
        } else {
            document.body.classList.add('aside-open');
        }
    }
}
toggleSubmenu = function(event) {
    event.preventDefault();
    submenu = event.toElement;
    if(submenu.classList.contains('submenu-open')){
        submenu.classList.remove('submenu-open');
    } else  {
        submenu.classList.add('submenu-open');
    }
}

document.querySelector('.aside-toggle').addEventListener('click', event => toggleAside(event));
document.querySelector('.submenu-toggle').addEventListener('click', event => toggleSubmenu(event))


function isMobile() {
    return window.innerWidth <= 768;
}