CREATE TABLE outgoings
(
  id SERIAL PRIMARY KEY,
  sub_type_id INTEGER references outgoing_sub_types(id) NOT NULL,
  voucher_id integer references outgoing_voucher(id) NOT NULL,
  quantity integer NOT NULL,
  total_price float NOT NULL
);
