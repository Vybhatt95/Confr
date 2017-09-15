var app = angular.module('app');

app.component('home',{
    templateUrl: 'components/home/home.html',
    controller: homeController
})

function homeController($mdSidenav, $mdDialog, $location, $http, ListService, UserService) {
  var ctrl = this;

  ctrl.currentNavItem="page1";
  ctrl.$onInit = function() {
      console.log("wassip");
  }

  ctrl.currentUser;

  $http({
    url: 'http://localhost:8080/users/user',
    method: 'GET'
  }).then(function(response){
    ctrl.currentUser = response.data;
  },function(response){
  })


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
    ctrl.currentNavItem = page;
    ctrl.pages = page;
    console.log(page);
  }

  ctrl.logout = function() {
    $http({
      url: "http://localhost:8080/users/logout",
      method: "GET",
    }).then(function(response){
      alert(response.data);
      console.log("logging out");
      $location.path("/");
      ListService.lists = [];
      UserService.currUser = {};
    }), function(response) {
      console.log("log out failed");
    }
  }
}
