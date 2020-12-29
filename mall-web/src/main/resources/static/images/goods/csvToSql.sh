#!/bin/bash
# read file and create INSERT statement for MYSQL

outfile="mem.sql"
IFS=","
while read id name code price count status create_date detail packing_unit brand_name category_name
do
  cat >> $outfile << EOF
  INSERT INTO shopWWSSing_product (id, name, code, price, count, status, create_date, detail, packing_unit, brand_name, category_name) VALUES
  ($id, $name, $code, $price, $count, $status, $create_date, $detail, $packing_unit, $brand_name, $category_name);
EOF
done < ${1}
