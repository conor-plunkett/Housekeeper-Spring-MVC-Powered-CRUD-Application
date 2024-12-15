// Variables imported
// /*<![CDATA[*/
// var cleaned = /*[[${stats.cleaned}]]*/ Test;
// var dirty = /*[[${stats.dirty}]]*/ Test;
// var inactive = /*[[${stats.inactive}]]*/ Test;
// var total = /*[[${stats.total}]]*/ Test;
// /*]]>*/

// Timestamp func
var timeDiv = document.getElementById("time");
var currentdate = new Date(); 
var insertion = "";
if(currentdate.getMinutes < 10) {
  insertion = '0';
}
var datetime = "Last updated: " + currentdate.getDate() + "/"
                + (currentdate.getMonth()+1)  + "/" 
                + currentdate.getFullYear() + " @ "  
                + currentdate.getHours() + ":"  
                + insertion
                + currentdate.getMinutes();
var t = document.createTextNode(datetime);
var p = document.createElement("P");
p.appendChild(t);
timeDiv.appendChild(p);

// Pie chart
var ctx = document.getElementById("cleanedPieChart");
var cleanedPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ["Dirty", "Cleaned", "Inactive"],
        datasets: [{
            data: [dirty, cleaned, inactive],
            backgroundColor: ['#ffc107','#28a745', '#dc3545'], 
        }],
    },
});

// Bar Chart
var ctx = document.getElementById("cleanedBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["Cleaned", "Dirty"],
    datasets: [{
      label: "Count",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [cleaned, dirty],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'Rooms Cleaned'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: total,
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});



