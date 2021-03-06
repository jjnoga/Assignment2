/*  Country.java
    Authors: Aiden Rosen and Joseph Noga
    Class: SER210
    Professor: Rehab ElKharboutly
    Date: 16 March 2022
    Description: Provides the data for the countries' names which will be involved in the comparisons
    provided by the app.
 */

package edu.quinnipiac.ser210.assignment2;


public class Country {

    //array of country names instance variable
    private String[] countryNames;

    //constructor
    public Country() {
        //defines the list of all possible countries the API works with here
        countryNames = new String[]{"Afghanistan", "Albania", "Algeria", "Andorra", "Angola",
        "Antigua And Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan",
        "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
        "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso",
        "Burundi", "Cape Verde", "Cambodia", "Cameroon", "Canada", "Central African" +
                " Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo, The " +
                "Democratic Republic Of The", "Costa Rica", "Cote D'ivoire", "Croatia", "Cuba",
                "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "Ecuador", "Egypt", "El Salvador", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland",
        "France", "Gabon", "Gambia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea",
        "Guinea-Bissau", "Guyana", "Haiti", "Holy See (Vatican City State)", "Honduras", "Hungary",
        "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic Of",
                "Korea, Republic Of", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
        "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia",
        "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia, Federated States Of",
        "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
        "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
        "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts And Nevis",
                "Saint Vincent And The Grenadines", "Samoa", "San Marino", "Sao Tome And Principe",
                "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia",
        "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka",
        "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania",
                "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad And Tobago", "Tunisia", "Turkey",
        "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
        "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};


    }

    //getter for the array
    public String[] getCountries() {
        return countryNames;
    }
}
