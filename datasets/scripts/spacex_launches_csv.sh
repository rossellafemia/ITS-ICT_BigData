

echo "#flight_number,mission_name,launch_date_utc,launch_success,details"
curl --silent --location --request GET 'https://api.spacexdata.com/v3/launches' | jq -r '. |  map([.flight_number, .mission_name, .launch_date_utc, .launch_success, .details] | join(",")) | join("\n")'  