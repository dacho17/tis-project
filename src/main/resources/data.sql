insert into product (created_date, code, name, price_eur, price_usd, description)
values
(CURRENT_TIMESTAMP(), 'ABCDEFGHIJ00001', 'Football', 100, 120, 'Official match ball'),
(CURRENT_TIMESTAMP(), 'ABCDEFGHIJ00002', 'Boots', 90, 105, 'Mike football boots.'),
(CURRENT_TIMESTAMP(), 'ABCDEFGHIJ00003', 'Jersey', 50, 60, 'Undro football jersey.'),
(CURRENT_TIMESTAMP(), 'ABCDEFGHIJ00004', 'Shin pads', 20, 18, 'Mike shin pads.'),
(CURRENT_TIMESTAMP(), 'ABCDEFGHIJ00005', 'Stockings', 20, 18, 'Undro stockings.')
;


insert into review (created_date, product_id, reviewer, text, rating)
values
(CURRENT_TIMESTAMP(), 1, 'Luka Modric', 'Great ball. I made 20 assists with it.', 5),
(CURRENT_TIMESTAMP(), 1, 'Marcelo Brozovic', 'Amazing ball. It is of size 5.', 5),
(CURRENT_TIMESTAMP(), 2, 'Mario Mandzukic', 'Slippery boots. I slipped with them going 1 v 1.', 2),
(CURRENT_TIMESTAMP(), 2, 'Mateo Kovacic', 'Sweet boots. They glow in dark.', 5),
(CURRENT_TIMESTAMP(), 3, 'Ivan Perisic', 'Black and blue jersey. My favorite.', 5),
(CURRENT_TIMESTAMP(), 3, 'Ivan Rakitic', 'White and red jersey. Good for the end of my career.', 4),
(CURRENT_TIMESTAMP(), 4, 'Josko Gvardiol', 'Great for protection.', 5),
(CURRENT_TIMESTAMP(), 4, 'Josip Sutalo', 'They do not cover the entirety of my legs.', 3),
(CURRENT_TIMESTAMP(), 5, 'Borna Sosa', 'Funny stockings. Took from Pippy long stocking.', 3),
(CURRENT_TIMESTAMP(), 5, 'Josip Juranovic', 'Comfortable stockings.', 4),
(CURRENT_TIMESTAMP(), 3, 'Stipe Pletikosa', 'Warm and comfy jersey.', 5)
;
