# MobileGroupProject
Mobile web development group project 2016

-- Assingment Instruction --

Project Details:

This assignment is a GROUP project intended to exercise skills in major web technologies focused on development of a rich website targeted for mobile phones.

Part 1: Group Information
    * Group Information:
        * Group member names
        * Student numbers
        * Login names
        * Program
    * Name of group member who will receive the XML file and unique hospital name for the group from the professor
    * Name of group member who will upload final project to PROJECT-FINAL drop box
    * NOTE: If you do not indicate a group, I will assume you will be working on your own. However, this is a large project and you will face the same deadlines as those working in groups.
    * Groups can have up to 4 members
    * NOTE: If all the information is not included AND not in a MS Word document, point will not be given. An email is not acceptable.
    
Part 2: Project Detail

* General Information:
    * Group project must use jQuery Mobile with mandatory header and footer sections included as specified below
    * Each group will use the XML file sent from the professor which must be updated (see specifics below) and validated
    * Each group will create 2 unique JSON files (see below for specifics) that must also be validated
* XML file specifics:
    * Update your group's XML file to to include icon/image/photo/picture/symbol names (node name will depend on specific XML file) where indicated in XML
    * Be sure to validate your XML after adding this information.
* Create JSON file #1 which must include the following data about each member of the group:
    * Full name
    * Student login
    * Student number
    * Student picture
* Create JSON file #2 which must include the following data:
    * An overall node called Hospital
    * Include data for unique hospital for your group (sent with group email):
        * Hospital Name
        * City where located
        * URL for hospital
        * Main phone number
        * Longitude
        * Latitude
        * Sub-Array labeled Departments and include 4 departments/specialities/areas of care associated with the hospital and for each include:
            * Department/Specialty/Area of Care name
            * A brief description of the department/area of care
            * Fact #1: A fact about the department/specialty/area of care
            * Fact #2: A fact about the department/specialty/area of care
                * Note: These facts can be anything such as date established, Contact Info for department/area of care, head of department, etc.
* All pages must include:
    * A header section that includes a name for your site (your choice)

    * A footer section that includes a navigation bar with links to each person in the group using the student picture from the JSON #1 file as the icon. When a link is selected, display all the information about the student selected in a popup dialog box with data pulled from the JSON file.
    * NOTE: This is the minimum that must be included in the header and footer but other information can be included.
* Content:
    * Design your web site to include all information from your group's XML file and also from your group's JSON #2 file with the header and footer as described above.
        * Example: include links on the main page to 2 separate pages ... one for the XML data and one for hospital data
        * Example: build a list from XML data with links to detail information for each selection for main page with a button to another page for hospital data
        * Example: Split main page to include half for a list of XML data items with links to another page for detail information and the other half that includes hospital data
    * Other information (page) that must be included:
        * A page (or popup based on a button) that includes a Google Mapwith the following details:
            * A marker at your group's hospital location based on longitude and lattitude included in your JSON #2 file. When this marker is clicked, display an information window that includes the hospital name and city
            * A marker at your campus location. When this marker is clicked, display an information window that includes the names of each person in the group.
            * Include a polyline between the two markers

    * Your group will decide how and where information will be located (landscape mode only) including formatting that follows mobile guidelines as discussed in class

    * Note: Your site must have multiple pages

    * Note: Your site is for mobile so make sure you follow all mobile best practices discussed in class such as ...
        * Navigation MUST be included between all pages
        * Avoid too much whitespace
        * Minimal scrolling
        * Image sizes should applicable for a mobile device
        * Descriptive labels for all information
