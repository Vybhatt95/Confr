var app = angular.module('app');

app.component('analysisSw', {
    templateUrl: 'components/analysis/analysis-sw.html',
    controller: AnalysisController
})

function AnalysisController() {
    var ctrl = this;
    ctrl.listData = [];

    ctrl.myDataSource = {
        chart: {
            caption: "Harry's SuperMart",
            subCaption: "Top 5 stores in last month by revenue",
        },
        data:[{
            label: "Bakersfield Central",
            value: "8"
        },
        {
            label: "Garden Groove harbour",
            value: "73"
        },
        {
            label: "Los Angeles Topanga",
            value: "59"
        },
        {
            label: "Compton-Rancho Dom",
            value: "52"
        },
        {
            label: "Daly City Serramonte",
            value: "33"
        }]
      };

      ctrl.myData = {
        chart: {
            caption: "Age profile of website visitors",
            subcaption: "Last Year",
            startingangle: "120",
            showlabels: "0",
            showlegend: "1",
            enablemultislicing: "0",
            slicingdistance: "15",
            showpercentvalues: "1",
            showpercentintooltip: "0",
            plottooltext: "Age group : $label Total visit : $datavalue",
            theme: "ocean"
        },
        data: [
            {
                label: "Teenage",
                value: "1250400"
            },
            {
                label: "Adult",
                value: "1463300"
            },
            {
                label: "Mid-age",
                value: "1050700"
            },
            {
                label: "Senior",
                value: "491000"
            }
        ]
    }
}
