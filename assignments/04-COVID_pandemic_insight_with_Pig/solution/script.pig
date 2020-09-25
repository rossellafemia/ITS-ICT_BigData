dataset = LOAD 'ass4_input/dpc-covid19-ita-regioni.csv' USING PigStorage(',')
   as (data:chararray, stato:chararray, codice_regione:chararray ,denominazione_regione:chararray, lat:double ,long:double, ricoverati_con_sintomi:int, terapia_intensiva:int ,totale_ospedalizzati:int, isolamento_domiciliare:int, totale_positivi:int, variazione_totale_positivi:int, nuovi_positivi:int, dimessi_guariti:int, deceduti:int, casi_da_sospetto_diagnostico:int, casi_da_screening:int, totale_casi:int, tamponi:int, casi_testati:int, note:chararray);
group_data = GROUP dataset by data;
result = foreach group_data generate group, SUM(dataset.nuovi_positivi);  
dump result;