var app = angular.module('app');

app.component('analysisSw', {
    templateUrl: 'components/analysis/analysis-sw.html',
    controller: AnalysisController
})

function AnalysisController($http) {
    var ctrl = this;
    ctrl.listData = [];
    ctrl.averageData = [];

    ctrl.$onInit = function() {
        $http({
            url: "http://localhost:8080/lists/average",
            method: "POST"
        }).then(function(response){
            ctrl.averageData = response.data;
            console.log(ctrl.averageData);

            FusionCharts.ready(function() {
                var avgChart = new FusionCharts({
                    "type": "column2d",
                    "renderAt": "averageChart",
                    "width": "500",
                    "height": "300",
                    "dataFormat": "json",
                    "dataSource": {
                        "chart": {
                            "caption": "Average Spending Comparison",
                            "yAxisName": "Spending (In USD)",
                            "theme": "ocean"
                        },
        
                        "data": [
                            {
                                "label": ctrl.averageData[0].label,
                                "value": ctrl.averageData[0].value
                            },
                            {
                                "label": ctrl.averageData[1].label,
                                "value": ctrl.averageData[1].value
                            }
                        ]
                    }
                });
        
                avgChart.render();
            })
        }), function(response) {
            console.log(response.data);
        }
    }


}
