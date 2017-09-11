var app = angular.module('app');

app.component('home',{
    templateUrl: 'components/home/home.html',
    controller: homeController
})

function homeController($mdSidenav, $mdDialog, $location) {
  var ctrl = this;

  ctrl.$onInit = function() {
      console.log("wassip");
  }

  ctrl.showDialog = function(ev) {
    $mdDialog.show({
      template: '<change-pass></change-pass>',
      targetEvent: ev,
      clickOutsideToClose:true
      
    }).then(function(answer) {
      console.log(answer);
    }, function() {
      console.log("cancelled");
    })
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

  ctrl.logout = function() {
    $location.path("/");
  }
}
