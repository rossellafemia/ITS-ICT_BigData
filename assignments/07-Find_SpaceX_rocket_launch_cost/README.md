# Find SpaceX rocket launch cost

By joining the RDDs created from files [datasets/spacex_launches.csv](../../datasets/spacex_launches.csv) and [datasets/spacex_rockets.csv](../../datasets/spacex_rockets.csv), discover the rocket cost for each launch.

Dataset **spacex_launches.csv** is structured as follows:

```csv
#flight_number;mission_name;launch_date_utc;launch_success;details;rocket_id
```

Use the column **rocket_id** to INNER JOIN the dataset  **spacex_rockets.csv**, which is structured as follows:

```csv
#rocket_id;cost_per_launch
```

Then print similar to:

```
(1,())
```