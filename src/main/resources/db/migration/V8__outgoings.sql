CREATE TABLE outgoing_voucher
(
  id SERIAL PRIMARY KEY,
  sub_type_id INTEGER references outgoing_sub_types(id),
  voucher_id integer references outgoing_voucher(id),
  quantity integer,
  total_price float
);
