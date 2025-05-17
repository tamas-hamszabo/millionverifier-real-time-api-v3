<?php

// !!! PUT YOUR API KEY HERE !!!
$api_key = "YOUR_API_KEY";

// email for verification
$email = "info@millionverifier.com";


$j = json_decode(file_get_contents("https://api.millionverifier.com/api/v3/?api=$api_key&email=$email"));

switch($j->resultcode) {
	case 1:
		echo "Ok";
		break;
	case 2:
		echo "Catch All";
		break;
	case 3:
		echo "Unknown";
		break;
	case 4:
		echo "Error: ".$j->error;
		break;
	case 5:
		echo "Disposable";
		break;
        case 6:
                echo "Invalid";
                break;
}

