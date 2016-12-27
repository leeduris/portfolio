var myXML;
var myHospital;
var myGroup;
var studentID;


$(document).on('pagebeforeshow', '#home', function () {
    console.log('in doc on');
    $.ajax({
        type: 'GET',
        url: 'XML07-generalhealthdefinitions.xml',
        dataType: 'xml',
        success: parseXML
    });

    $.getJSON("group.json", parseGroup);

    $.getJSON("hospital.json", function(data) {
        console.log(data);

        hospitalInfo = data.hospital;
        departmentInfo = data.hospital.department;

        for(x=0; x<departmentInfo.length; x++) {
            $('#part'+(x+1)).html(departmentInfo[x].area);
        }

        $('#infoTitle').html('<h3>' + hospitalInfo.name + '</h3>');

        $('#hostpitalInfo1').html (
            '<h4 class="hospitalDesc"> - Address: ' + hospitalInfo.address + '</h4>' +
            '<h4 class="hospitalDesc"> - City: ' + hospitalInfo.city + '</h4>' +
            '<h4 class="hospitalDesc"> - Province: ' + hospitalInfo.province + '</h4>' +
            '<h4 class="hospitalDesc"> - Postal Code: ' + hospitalInfo.postal + '</h4>'
        );

        $('#hostpitalInfo2').html (
            '<h4 class="hospitalDesc"> - Phone: ' + hospitalInfo.phone + '</h4>' 	+
            '<h4 class="hospitalDesc"> - Latitude: ' + hospitalInfo.lat + '</h4>' +
            '<h4 class="hospitalDesc"> - Logtitude: ' + hospitalInfo.long + '</h4>'
        );



        // Popup Setting
        $("#part1").click(function() {
            $("#depTitle").html("<h3>" + departmentInfo[0].area + "</h3>");
            $("#depDesc").html(
                "<h5>" + departmentInfo[0].description + "</h5>" +
                "<h5>" + departmentInfo[0].head + " (" + departmentInfo[0].contact + ")" + "</h5>"
            );
            $("#depImg").html(
                "<img  src='" + departmentInfo[0].image + "' width='250px' >"
            );
        });

        $("#part2").click(function() {
            $("#depTitle").html("<h3>" + departmentInfo[1].area + "</h3>");
            $("#depDesc").html(
                "<h5>" + departmentInfo[1].description + "</h5>" +
                "<h5>" + departmentInfo[1].head + " (" + departmentInfo[1].contact + ")" + "</h5>"
            );
            $("#depImg").html(
                "<img src='" + departmentInfo[1].image + " ' width='250px'>"
            );
        });
        $("#part3").click(function() {
            $("#depTitle").html("<h3>" + departmentInfo[2].area + "</h3>");
            $("#depDesc").html(
                "<h5>" + departmentInfo[2].description + "</h5>" +
                "<h5>" + departmentInfo[2].head + " (" + departmentInfo[2].contact + ")" + "</h5>"
            );
            $("#depImg").html(
                "<img src='" + departmentInfo[2].image + "' width='250px'>"
            );
        });
        $("#part4").click(function() {
            $("#depTitle").html("<h3>" + departmentInfo[3].area + "</h3>");
            $("#depDesc").html(
                "<h5>" + departmentInfo[3].description + "</h5>" +
                "<h5>" + departmentInfo[3].head + " (" + departmentInfo[3].contact + ")" + "</h5>"
            );
            $("#depImg").html(
                "<img src='" + departmentInfo[3].image + "' width='250px'>"
            );
        });

    });

});

function parseXML(xml) {
    console.log('in parseXML...');
    console.log(xml);
    myXML = xml;

}

function parseGroup(group) {
    myGroup = group;
}

function parseHospital(hospital) {
    myHospital = hospital;
}


$(document).on("click", "#studentmenu >li", function () {

    studentID = $(this).closest("li").attr("li-id");
    studentPage(studentID);
});

function studentPage(id) {

    //set student profile image
    $("#student-content .ui-block-a").html("<img src='_css/images/" + myGroup.student[id].pic + "' class='studentpic'>");

    // add name, login and studentId
    $("#student-content .ui-block-b").html("<p><strong>Name</strong>: " + myGroup.student[id].name + "</p>");
    $("#student-content .ui-block-b").append("<p><strong>Login</strong>: " + myGroup.student[id].login + "</p>");
    $("#student-content .ui-block-b").append("<p><strong>Student ID</strong>: " + myGroup.student[id].id + "</p>");


}

// things to run only once
$(document).ready(function () {
    $("#studentheader").html("<h1>Student Profile</h1>");

});


$(document).on("pagebeforeshow", "#terms", function () {
    console.log('in terms');

    $("#termsCollapsible").html("");

    // populate hospital terms from xml to Terms page
    $(myXML).find("term-group").each(function () {
        $(this).find("term").each(function () {

            $("#termsCollapsible").append(
                "<section data-role='collapsible' data-collapsed-icon='carat-d' data-expanded-icon='carat-u'>" +
                "<h2 class='ui-title'>" + $(this).text() + "</h2>" +
                "<p>" + $(this).next().text() + "</p>" +
                "<img src='_images/" + $(this).next().next().text() + "' height='50px' width='50px' alt='term icon'>" +
                "</section>"
            );

        });

        $("#termsCollapsible").collapsibleset("refresh");
    });
});


// Display Map in the Pup-Up Page
$(document).on("pageshow", "#maps", function() {
    console.log('Hello, Good Map');

    $.getJSON("hospital.json", function(data) {
        console.log('Hello, Good Map JSON');
        var hospitalname = data.hospital.name;
        var hostipalcity = data.hospital.city;
        var latHospital = data.hospital.lat;
        var longHospital = data.hospital.long;
        var latCampus = 43.46928;
        var longCampus = -79.698683;

        // Make map objects
        mapHospital = new google.maps.LatLng(latHospital, longHospital);
        mapCenter = new google.maps.LatLng(43.614310, -79.551072);
        mapCampus = new google.maps.LatLng(latCampus, longCampus);


        // Set map options
        mapOptions = {
            center: mapCenter,
            zoom: 9,
            mapTypeId: google.maps.MapTypeId.HYBRID
        }

        //draw map
        map = new google.maps.Map(document.getElementById("mapCanvas"), mapOptions);

        //marker
        hospitalLoc = new google.maps.Marker({
            map: map,
            icon: "_images/pushpin.gif",
            animation: google.maps.Animation.DROP,
            position: mapHospital,
            title: 'Hospital'
        });

        campusLoc = new google.maps.Marker({
            map: map,
            icon: "_images/pushpin.gif",
            animation: google.maps.Animation.DROP,
            position: mapCampus,
            title: 'Oakville Campus'
        });

        pathCoordinates = [
            {lat: latHospital, lng: longHospital},
            {lat: 43.762768, lng: -79.388337},
            {lat: 43.733503, lng: -79.437088},
            {lat: 43.701245, lng: -79.562058},
            {lat: 43.675923, lng: -79.578537},
            {lat: 43.614310, lng: -79.550385},
            {lat: 43.503348, lng: -79.673981},
            {lat: 43.461497, lng: -79.682908},
            {lat: latCampus, lng: longCampus}
        ];

        // info window
        infoHospital = new google.maps.InfoWindow({
            content: hospitalname + "<br>" + hostipalcity
        });

        infoCampus = new google.maps.InfoWindow({
            content: "Bruno Petla" + "<br>" +
            "Douglas Petla" + "<br>" +
            "Myungsuk Choi" + "<br>" +
            "Sungwoo Lee"
        });

        // add listener
        google.maps.event.addDomListener(hospitalLoc, "click", function(){
            infoHospital.open(map, hospitalLoc);
            console.log('hospital marker');
        });

        google.maps.event.addDomListener(campusLoc, "click", function(){
            infoCampus.open(map, campusLoc);
            console.log('campus marker');
        });

        var myPath = new google.maps.Polyline({
            path: pathCoordinates,
            strokeColor: "#ff0000",
            strokeOpacity: 1.0,
            strokeWeight: 2
        });

        myPath.setMap(map);

    });
});


