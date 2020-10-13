

echo "#id;rocket_id;cost_per_launch"
curl --silent --location --request GET 'https://api.spacexdata.com/v3/rockets' | jq -r '. |  map([.id, .rocket_id, .cost_per_launch] | join(";")) | join("\n")'  
