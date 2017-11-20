function valid()
{
    var x = document.forms["myForm"]["fName"].value;
    var y = document.forms["myForm"]["lName"].value;
    var z = document.forms["myForm"]["MAC"].value;
    var a = document.forms["myForm"]["device"].value;
    var b = document.forms["myForm"]["band"].value;
    var i = document.forms["myForm"]["IP"].value;
    var f = document.forms["myForm"]["select"].value;
    var MAC = new RegExp('^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$');
    var o = '(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])';
    var p = '(?:' + o + '\\.){3}' + o;
    var q = '(?:' + p + ')';
    var ip = new RegExp('(' + q + ')');


    if (!isNaN(x))
    {
        alert("Plese enter string for first name");
        return false;
    }
    if (x.length > 30)
    {
        alert("Your first name should not exceed 30 characters");
        return false;
    }


    if (!isNaN(y))
    {
        alert("Plese enter string for last name");
        return false;
    }

    if (y.length > 30)
    {
        alert("Your last name should not exceed 20 characters");
        return false;
    }

    if (MAC.test(z)) {
    } else {
        alert('Invalid MAC address. Please check the format.\nEg: 00:4F:78:93:56:12');
        return false;
    }

    if (a.length > 30)
    {
        alert("Your max length of Device name should not exceed 30");
        return false;
    }
    if (!isNaN(a)) {
        alert("Plese enter string for device name");
        return false;
    }

    

    if (ip.test(i)) {

    } else {
        alert('Invalid IP address.Please check the format.\nEg:192.168.172.212');
        return false;
    }

    if (typeof b !== 'number' && (b % 1) !== 0) {
        alert("Please enter an integer for bandwidth");
        return false;
    }

    if (b.length > 7) {
        alert("Your maximum length is 7 for bandwidth");
        return false;
    }
    
    if (f.selectedIndex === 0 || f.options[f.selectedIndex].value === -1) {
        alert('select another option!');
        return false;
    }

}


