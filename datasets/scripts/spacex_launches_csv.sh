

echo "#flight_number;mission_name;launch_date_utc;launch_success;details;rocket_id"
curl --silent --location --request GET 'https://api.spacexdata.com/v3/launches' | jq -r '. |  map([.flight_number, .mission_name, .launch_date_utc, .launch_success, .details, .rocket.rocket_id] | join(";")) | join("\n")'  
