var app = angular.module('app');

app.component('home',{
    templateUrl: 'components/home/home.html',
    controller: homeController
})

function homeController($mdSidenav) {
  var ctrl = this;

  ctrl.$onInit = function() {
      console.log("wassip");
  }
//Methods for SIDE BAR
  ctrl.showMobileMainHeader = true;
	ctrl.openSideNavPanel = function() {
		$mdSidenav('left').open();
	};
	ctrl.closeSideNavPanel = function() {
		$mdSidenav('left').close();
	};

//Methods for the navbar
ctrl.goto = function(page){
  this.pages = page;
  console.log(page);
}



}
