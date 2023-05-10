-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 10, 2022 lúc 05:09 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7
USE foodapp;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: dataonline
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng meals
--
DROP TABLE IF EXISTS meals;
CREATE TABLE meals (
  id int(11) NOT NULL,
  strMeal varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  strMealThumb varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  idMeal int(11) NOT NULL,
  idcategory int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng meals
--

INSERT INTO meals (id, strMeal, strMealThumb, idMeal, idcategory) VALUES
(292, 'Beef and Mustard Pie', 'https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg', 52874, 1),
(293, 'Beef and Oyster pie', 'https://www.themealdb.com/images/media/meals/wrssvt1511556563.jpg', 52878, 1),
(294, 'Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber', 'https://www.themealdb.com/images/media/meals/z0ageb1583189517.jpg', 52997, 1),
(295, 'Beef Bourguignon', 'https://www.themealdb.com/images/media/meals/vtqxtu1511784197.jpg', 52904, 1),
(296, 'Beef Brisket Pot Roast', 'https://www.themealdb.com/images/media/meals/ursuup1487348423.jpg', 52812, 1),
(297, 'Beef Dumpling Stew', 'https://www.themealdb.com/images/media/meals/uyqrrv1511553350.jpg', 52873, 1),
(298, 'Beef Lo Mein', 'https://www.themealdb.com/images/media/meals/1529444830.jpg', 52952, 1),
(299, 'Beef Rendang', 'https://www.themealdb.com/images/media/meals/bc8v651619789840.jpg', 53053, 1),
(300, 'Beef stroganoff', 'https://www.themealdb.com/images/media/meals/svprys1511176755.jpg', 52834, 1),
(301, 'Beef Sunday Roast', 'https://www.themealdb.com/images/media/meals/ssrrrs1503664277.jpg', 52824, 1),
(302, 'Beef Wellington', 'https://www.themealdb.com/images/media/meals/vvpprx1487325699.jpg', 52803, 1),
(303, 'Big Mac', 'https://www.themealdb.com/images/media/meals/urzj1d1587670726.jpg', 53013, 1),
(304, 'Bitterballen (Dutch meatballs)', 'https://www.themealdb.com/images/media/meals/lhqev81565090111.jpg', 52979, 1),
(305, 'Braised Beef Chilli', 'https://www.themealdb.com/images/media/meals/uuqvwu1504629254.jpg', 52826, 1),
(306, 'Cevapi Sausages', 'https://www.themealdb.com/images/media/meals/vc08jn1628769553.jpg', 53055, 1),
(307, 'Chivito uruguayo', 'https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg', 53063, 1),
(308, 'Corned Beef and Cabbage', 'https://www.themealdb.com/images/media/meals/xb97a81583266727.jpg', 52998, 1),
(309, 'Croatian Bean Stew', 'https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg', 53058, 1),
(310, 'Croatian lamb peka', 'https://www.themealdb.com/images/media/meals/pn59o51628769837.jpg', 53056, 1),
(311, 'Egyptian Fatteh', 'https://www.themealdb.com/images/media/meals/rlwcc51598734603.jpg', 53031, 1),
(312, 'Gołąbki (cabbage roll)', 'https://www.themealdb.com/images/media/meals/q8sp3j1593349686.jpg', 53021, 1),
(313, 'Irish stew', 'https://www.themealdb.com/images/media/meals/sxxpst1468569714.jpg', 52781, 1),
(314, 'Jamaican Beef Patties', 'https://www.themealdb.com/images/media/meals/wsqqsw1515364068.jpg', 52938, 1),
(315, 'Ma Po Tofu', 'https://www.themealdb.com/images/media/meals/1525874812.jpg', 52947, 1),
(316, 'Massaman Beef curry', 'https://www.themealdb.com/images/media/meals/tvttqv1504640475.jpg', 52827, 1),
(317, 'Minced Beef Pie', 'https://www.themealdb.com/images/media/meals/xwutvy1511555540.jpg', 52876, 1),
(318, 'Montreal Smoked Meat', 'https://www.themealdb.com/images/media/meals/uttupv1511815050.jpg', 52927, 1),
(319, 'Moussaka', 'https://www.themealdb.com/images/media/meals/ctg8jd1585563097.jpg', 53006, 1),
(320, 'Mulukhiyah', 'https://www.themealdb.com/images/media/meals/x372ug1598733932.jpg', 53029, 1),
(321, 'Oxtail with broad beans', 'https://www.themealdb.com/images/media/meals/1520083578.jpg', 52943, 1),
(322, 'Paszteciki (Polish Pasties)', 'https://www.themealdb.com/images/media/meals/c9a3l31593261890.jpg', 53017, 1),
(323, 'Pate Chinois', 'https://www.themealdb.com/images/media/meals/yyrrxr1511816289.jpg', 52930, 1),
(324, 'Portuguese prego with green piri-piri', 'https://www.themealdb.com/images/media/meals/ewcikl1614348364.jpg', 53042, 1),
(325, 'Red Peas Soup', 'https://www.themealdb.com/images/media/meals/sqpqtp1515365614.jpg', 52941, 1),
(326, 'Roti john', 'https://www.themealdb.com/images/media/meals/hx335q1619789561.jpg', 53052, 1),
(327, 'Soy-Glazed Meatloaves with Wasabi Mashed Potatoes & Roasted Carrots', 'https://www.themealdb.com/images/media/meals/o2wb6p1581005243.jpg', 52992, 1),
(328, 'Spaghetti Bolognese', 'https://www.themealdb.com/images/media/meals/sutysw1468247559.jpg', 52770, 1),
(329, 'Steak and Kidney Pie', 'https://www.themealdb.com/images/media/meals/qysyss1511558054.jpg', 52881, 1),
(330, 'Steak Diane', 'https://www.themealdb.com/images/media/meals/vussxq1511882648.jpg', 52935, 1),
(331, 'Szechuan Beef', 'https://www.themealdb.com/images/media/meals/1529443236.jpg', 52950, 1),
(332, 'Traditional Croatian Goulash', 'https://www.themealdb.com/images/media/meals/n1hcou1628770088.jpg', 53057, 1),
(333, 'Vegetable Shepherd\'s Pie', 'https://www.themealdb.com/images/media/meals/w8umt11583268117.jpg', 53000, 1),
(334, 'Ayam Percik', 'https://www.themealdb.com/images/media/meals/020z181619788503.jpg', 53050, 2),
(335, 'Brown Stew Chicken', 'https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg', 52940, 2),
(336, 'Chick-Fil-A Sandwich', 'https://www.themealdb.com/images/media/meals/sbx7n71587673021.jpg', 53016, 2),
(337, 'Chicken & mushroom Hotpot', 'https://www.themealdb.com/images/media/meals/uuuspp1511297945.jpg', 52846, 2),
(338, 'Chicken Alfredo Primavera', 'https://www.themealdb.com/images/media/meals/syqypv1486981727.jpg', 52796, 2),
(339, 'Chicken Basquaise', 'https://www.themealdb.com/images/media/meals/wruvqv1511880994.jpg', 52934, 2),
(340, 'Chicken Congee', 'https://www.themealdb.com/images/media/meals/1529446352.jpg', 52956, 2),
(341, 'Chicken Couscous', 'https://www.themealdb.com/images/media/meals/qxytrx1511304021.jpg', 52850, 2),
(342, 'Chicken Enchilada Casserole', 'https://www.themealdb.com/images/media/meals/qtuwxu1468233098.jpg', 52765, 2),
(343, 'Chicken Fajita Mac and Cheese', 'https://www.themealdb.com/images/media/meals/qrqywr1503066605.jpg', 52818, 2),
(344, 'Chicken Ham and Leek Pie', 'https://www.themealdb.com/images/media/meals/xrrtss1511555269.jpg', 52875, 2),
(345, 'Chicken Handi', 'https://www.themealdb.com/images/media/meals/wyxwsp1486979827.jpg', 52795, 2),
(346, 'Chicken Karaage', 'https://www.themealdb.com/images/media/meals/tyywsw1505930373.jpg', 52831, 2),
(347, 'Chicken Marengo', 'https://www.themealdb.com/images/media/meals/qpxvuq1511798906.jpg', 52920, 2),
(348, 'Chicken Parmentier', 'https://www.themealdb.com/images/media/meals/uwvxpv1511557015.jpg', 52879, 2),
(349, 'Chicken Quinoa Greek Salad', 'https://www.themealdb.com/images/media/meals/k29viq1585565980.jpg', 53011, 2),
(350, 'Coq au vin', 'https://www.themealdb.com/images/media/meals/qstyvs1505931190.jpg', 52832, 2),
(351, 'Crock Pot Chicken Baked Tacos', 'https://www.themealdb.com/images/media/meals/ypxvwv1505333929.jpg', 52830, 2),
(352, 'French Onion Chicken with Roasted Carrots & Mashed Potatoes', 'https://www.themealdb.com/images/media/meals/b5ft861583188991.jpg', 52996, 2),
(353, 'General Tso\'s Chicken', 'https://www.themealdb.com/images/media/meals/1529444113.jpg', 52951, 2),
(354, 'Honey Balsamic Chicken with Crispy Broccoli & Potatoes', 'https://www.themealdb.com/images/media/meals/kvbotn1581012881.jpg', 52993, 2),
(355, 'Jerk chicken with rice & peas', 'https://www.themealdb.com/images/media/meals/tytyxu1515363282.jpg', 52937, 2),
(356, 'Katsu Chicken curry', 'https://www.themealdb.com/images/media/meals/vwrpps1503068729.jpg', 52820, 2),
(357, 'Kentucky Fried Chicken', 'https://www.themealdb.com/images/media/meals/xqusqy1487348868.jpg', 52813, 2),
(358, 'Kung Pao Chicken', 'https://www.themealdb.com/images/media/meals/1525872624.jpg', 52945, 2),
(359, 'Nutty Chicken Curry', 'https://www.themealdb.com/images/media/meals/yxsurp1511304301.jpg', 52851, 2),
(360, 'Pad See Ew', 'https://www.themealdb.com/images/media/meals/uuuspp1468263334.jpg', 52774, 2),
(361, 'Piri-piri chicken and slaw', 'https://www.themealdb.com/images/media/meals/hglsbl1614346998.jpg', 53039, 2),
(362, 'Potato Gratin with Chicken', 'https://www.themealdb.com/images/media/meals/qwrtut1468418027.jpg', 52780, 2),
(363, 'Rappie Pie', 'https://www.themealdb.com/images/media/meals/ruwpww1511817242.jpg', 52933, 2),
(364, 'Rosół (Polish Chicken Soup)', 'https://www.themealdb.com/images/media/meals/lx1kkj1593349302.jpg', 53020, 2),
(365, 'Shawarma', 'https://www.themealdb.com/images/media/meals/kcv6hj1598733479.jpg', 53028, 2),
(366, 'Tandoori chicken', 'https://www.themealdb.com/images/media/meals/qptpvt1487339892.jpg', 52806, 2),
(367, 'Teriyaki Chicken Casserole', 'https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg', 52772, 2),
(368, 'Thai Green Curry', 'https://www.themealdb.com/images/media/meals/sstssx1487349585.jpg', 52814, 2),
(369, 'Apam balik', 'https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg', 53049, 3),
(370, 'Apple & Blackberry Crumble', 'https://www.themealdb.com/images/media/meals/xvsurr1511719182.jpg', 52893, 3),
(371, 'Apple Frangipan Tart', 'https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg', 52768, 3),
(372, 'Bakewell tart', 'https://www.themealdb.com/images/media/meals/wyrqqq1468233628.jpg', 52767, 3),
(373, 'Banana Pancakes', 'https://www.themealdb.com/images/media/meals/sywswr1511383814.jpg', 52855, 3),
(374, 'Battenberg Cake', 'https://www.themealdb.com/images/media/meals/ywwrsp1511720277.jpg', 52894, 3),
(375, 'BeaverTails', 'https://www.themealdb.com/images/media/meals/ryppsv1511815505.jpg', 52928, 3),
(376, 'Blackberry Fool', 'https://www.themealdb.com/images/media/meals/rpvptu1511641092.jpg', 52891, 3),
(377, 'Bread and Butter Pudding', 'https://www.themealdb.com/images/media/meals/xqwwpy1483908697.jpg', 52792, 3),
(378, 'Budino Di Ricotta', 'https://www.themealdb.com/images/media/meals/1549542877.jpg', 52961, 3),
(379, 'Canadian Butter Tarts', 'https://www.themealdb.com/images/media/meals/wpputp1511812960.jpg', 52923, 3),
(380, 'Carrot Cake', 'https://www.themealdb.com/images/media/meals/vrspxv1511722107.jpg', 52897, 3),
(381, 'Cashew Ghoriba Biscuits', 'https://www.themealdb.com/images/media/meals/t3r3ka1560461972.jpg', 52976, 3),
(382, 'Chelsea Buns', 'https://www.themealdb.com/images/media/meals/vqpwrv1511723001.jpg', 52898, 3),
(383, 'Chinon Apple Tarts', 'https://www.themealdb.com/images/media/meals/qtqwwu1511792650.jpg', 52910, 3),
(384, 'Choc Chip Pecan Pie', 'https://www.themealdb.com/images/media/meals/rqvwxt1511384809.jpg', 52856, 3),
(385, 'Chocolate Avocado Mousse', 'https://www.themealdb.com/images/media/meals/uttuxy1511382180.jpg', 52853, 3),
(386, 'Chocolate Caramel Crispy', 'https://www.themealdb.com/images/media/meals/1550442508.jpg', 52966, 3),
(387, 'Chocolate Gateau', 'https://www.themealdb.com/images/media/meals/tqtywx1468317395.jpg', 52776, 3),
(388, 'Chocolate Raspberry Brownies', 'https://www.themealdb.com/images/media/meals/yypvst1511386427.jpg', 52860, 3),
(389, 'Chocolate Souffle', 'https://www.themealdb.com/images/media/meals/twspvx1511784937.jpg', 52905, 3),
(390, 'Christmas cake', 'https://www.themealdb.com/images/media/meals/ldnrm91576791881.jpg', 52990, 3),
(391, 'Christmas Pudding Flapjack', 'https://www.themealdb.com/images/media/meals/vvusxs1483907034.jpg', 52788, 3),
(392, 'Christmas Pudding Trifle', 'https://www.themealdb.com/images/media/meals/r33cud1576791081.jpg', 52989, 3),
(393, 'Classic Christmas pudding', 'https://www.themealdb.com/images/media/meals/1d85821576790598.jpg', 52988, 3),
(394, 'Dundee cake', 'https://www.themealdb.com/images/media/meals/wxyvqq1511723401.jpg', 52899, 3),
(395, 'Eccles Cakes', 'https://www.themealdb.com/images/media/meals/wtqrqw1511639627.jpg', 52888, 3),
(396, 'Eton Mess', 'https://www.themealdb.com/images/media/meals/uuxwvq1483907861.jpg', 52791, 3),
(397, 'Honey Yogurt Cheesecake', 'https://www.themealdb.com/images/media/meals/y2irzl1585563479.jpg', 53007, 3),
(398, 'Hot Chocolate Fudge', 'https://www.themealdb.com/images/media/meals/xrysxr1483568462.jpg', 52787, 3),
(399, 'Jam Roly-Poly', 'https://www.themealdb.com/images/media/meals/ysqupp1511640538.jpg', 52890, 3),
(400, 'Key Lime Pie', 'https://www.themealdb.com/images/media/meals/qpqtuu1511386216.jpg', 52859, 3),
(401, 'Krispy Kreme Donut', 'https://www.themealdb.com/images/media/meals/4i5cnx1587672171.jpg', 53015, 3),
(402, 'Madeira Cake', 'https://www.themealdb.com/images/media/meals/urtqut1511723591.jpg', 52900, 3),
(403, 'Mince Pies', 'https://www.themealdb.com/images/media/meals/qe8pf51576795532.jpg', 52991, 3),
(404, 'Nanaimo Bars', 'https://www.themealdb.com/images/media/meals/vwuprt1511813703.jpg', 52924, 3),
(405, 'New York cheesecake', 'https://www.themealdb.com/images/media/meals/swttys1511385853.jpg', 52858, 3),
(406, 'Pancakes', 'https://www.themealdb.com/images/media/meals/rwuyqx1511383174.jpg', 52854, 3),
(407, 'Parkin Cake', 'https://www.themealdb.com/images/media/meals/qxuqtt1511724269.jpg', 52902, 3),
(408, 'Peach & Blueberry Grunt', 'https://www.themealdb.com/images/media/meals/ssxvup1511387476.jpg', 52862, 3),
(409, 'Peanut Butter Cheesecake', 'https://www.themealdb.com/images/media/meals/qtuuys1511387068.jpg', 52861, 3),
(410, 'Peanut Butter Cookies', 'https://www.themealdb.com/images/media/meals/1544384070.jpg', 52958, 3),
(411, 'Pear Tarte Tatin', 'https://www.themealdb.com/images/media/meals/rxvxrr1511797671.jpg', 52916, 3),
(412, 'Polskie Naleśniki (Polish Pancakes)', 'https://www.themealdb.com/images/media/meals/58bkyo1593350017.jpg', 53022, 3),
(413, 'Portuguese custard tarts', 'https://www.themealdb.com/images/media/meals/vmz7gl1614350221.jpg', 53046, 3),
(414, 'Pouding chomeur', 'https://www.themealdb.com/images/media/meals/yqqqwu1511816912.jpg', 52932, 3),
(415, 'Pumpkin Pie', 'https://www.themealdb.com/images/media/meals/usuqtp1511385394.jpg', 52857, 3),
(416, 'Rock Cakes', 'https://www.themealdb.com/images/media/meals/tqrrsq1511723764.jpg', 52901, 3),
(417, 'Rocky Road Fudge', 'https://www.themealdb.com/images/media/meals/vtxyxv1483567157.jpg', 52786, 3),
(418, 'Rogaliki (Polish Croissant Cookies)', 'https://www.themealdb.com/images/media/meals/7mxnzz1593350801.jpg', 53024, 3),
(419, 'Salted Caramel Cheescake', 'https://www.themealdb.com/images/media/meals/xqrwyr1511133646.jpg', 52833, 3),
(420, 'Seri muka kuih', 'https://www.themealdb.com/images/media/meals/6ut2og1619790195.jpg', 53054, 3),
(421, 'Spotted Dick', 'https://www.themealdb.com/images/media/meals/xqvyqr1511638875.jpg', 52886, 3),
(422, 'Sticky Toffee Pudding', 'https://www.themealdb.com/images/media/meals/xqqqtu1511637379.jpg', 52883, 3),
(423, 'Sticky Toffee Pudding Ultimate', 'https://www.themealdb.com/images/media/meals/xrptpq1483909204.jpg', 52793, 3),
(424, 'Strawberry Rhubarb Pie', 'https://www.themealdb.com/images/media/meals/178z5o1585514569.jpg', 53005, 3),
(425, 'Sugar Pie', 'https://www.themealdb.com/images/media/meals/yrstur1511816601.jpg', 52931, 3),
(426, 'Summer Pudding', 'https://www.themealdb.com/images/media/meals/rsqwus1511640214.jpg', 52889, 3),
(427, 'Tarte Tatin', 'https://www.themealdb.com/images/media/meals/ryspuw1511786688.jpg', 52909, 3),
(428, 'Timbits', 'https://www.themealdb.com/images/media/meals/txsupu1511815755.jpg', 52929, 3),
(429, 'Treacle Tart', 'https://www.themealdb.com/images/media/meals/wprvrw1511641295.jpg', 52892, 3),
(430, 'Tunisian Orange Cake', 'https://www.themealdb.com/images/media/meals/y4jpgq1560459207.jpg', 52970, 3),
(431, 'Walnut Roll Gužvara', 'https://www.themealdb.com/images/media/meals/u9l7k81628771647.jpg', 53062, 3),
(432, 'White chocolate creme brulee', 'https://www.themealdb.com/images/media/meals/uryqru1511798039.jpg', 52917, 3),
(433, 'Kapsalon', 'https://www.themealdb.com/images/media/meals/sxysrt1468240488.jpg', 52769, 4),
(434, 'Keleya Zaara', 'https://www.themealdb.com/images/media/meals/8x09hy1560460923.jpg', 52974, 4),
(435, 'Lamb and Lemon Souvlaki', 'https://www.themealdb.com/images/media/meals/rjhf741585564676.jpg', 53009, 4),
(436, 'Lamb and Potato pie', 'https://www.themealdb.com/images/media/meals/sxrpws1511555907.jpg', 52877, 4),
(437, 'Lamb Biryani', 'https://www.themealdb.com/images/media/meals/xrttsx1487339558.jpg', 52805, 4),
(438, 'Lamb Rogan josh', 'https://www.themealdb.com/images/media/meals/vvstvq1487342592.jpg', 52808, 4),
(439, 'Lamb Tagine', 'https://www.themealdb.com/images/media/meals/yuwtuu1511295751.jpg', 52843, 4),
(440, 'Lamb tomato and sweet spices', 'https://www.themealdb.com/images/media/meals/qtwtss1468572261.jpg', 52782, 4),
(441, 'Lamb Tzatziki Burgers', 'https://www.themealdb.com/images/media/meals/k420tj1585565244.jpg', 53010, 4),
(442, 'Lancashire hotpot', 'https://www.themealdb.com/images/media/meals/uttrxw1511637813.jpg', 52884, 4),
(443, 'McSinghs Scotch pie', 'https://www.themealdb.com/images/media/meals/vssrtx1511557680.jpg', 52880, 4),
(444, 'Rigatoni with fennel sausage sauce', 'https://www.themealdb.com/images/media/meals/qtqvys1468573168.jpg', 52783, 4),
(445, 'Stuffed Lamb Tomatoes', 'https://www.themealdb.com/images/media/meals/u55lbp1585564013.jpg', 53008, 4),
(446, 'Tunisian Lamb Soup', 'https://www.themealdb.com/images/media/meals/t8mn9g1560460231.jpg', 52972, 4),
(447, 'Bean & Sausage Hotpot', 'https://www.themealdb.com/images/media/meals/vxuyrx1511302687.jpg', 52848, 5),
(448, 'Callaloo Jamaican Style', 'https://www.themealdb.com/images/media/meals/ussyxw1515364536.jpg', 52939, 5),
(449, 'Chakchouka ', 'https://www.themealdb.com/images/media/meals/gpz67p1560458984.jpg', 52969, 5),
(450, 'Duck Confit', 'https://www.themealdb.com/images/media/meals/wvpvsu1511786158.jpg', 52907, 5),
(451, 'French Lentils With Garlic and Thyme', 'https://www.themealdb.com/images/media/meals/vwwspt1487394060.jpg', 52815, 5),
(452, 'French Omelette', 'https://www.themealdb.com/images/media/meals/yvpuuy1511797244.jpg', 52915, 5),
(453, 'Osso Buco alla Milanese', 'https://www.themealdb.com/images/media/meals/wwuqvt1487345467.jpg', 52810, 5),
(454, 'Pizza Express Margherita', 'https://www.themealdb.com/images/media/meals/x0lk931587671540.jpg', 53014, 5),
(455, 'Poutine', 'https://www.themealdb.com/images/media/meals/uuyrrx1487327597.jpg', 52804, 5),
(456, 'Three-cheese souffles', 'https://www.themealdb.com/images/media/meals/sxwquu1511793428.jpg', 52912, 5),
(457, 'Turkey Meatloaf', 'https://www.themealdb.com/images/media/meals/ypuxtw1511297463.jpg', 52845, 5),
(458, 'Chilli prawn linguine', 'https://www.themealdb.com/images/media/meals/usywpp1511189717.jpg', 52839, 6),
(459, 'Fettucine alfredo', 'https://www.themealdb.com/images/media/meals/uquqtu1511178042.jpg', 52835, 6),
(460, 'Grilled Mac and Cheese Sandwich', 'https://www.themealdb.com/images/media/meals/xutquv1505330523.jpg', 52829, 6),
(461, 'Lasagna Sandwiches', 'https://www.themealdb.com/images/media/meals/xr0n4r1576788363.jpg', 52987, 6),
(462, 'Lasagne', 'https://www.themealdb.com/images/media/meals/wtsvxx1511296896.jpg', 52844, 6),
(463, 'Pilchard puttanesca', 'https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg', 52837, 6),
(464, 'Spaghetti alla Carbonara', 'https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg', 52982, 6),
(465, 'Venetian Duck Ragu', 'https://www.themealdb.com/images/media/meals/qvrwpt1511181864.jpg', 52838, 6),
(466, ' Bubble & Squeak', 'https://www.themealdb.com/images/media/meals/xusqvw1511638311.jpg', 52885, 7),
(467, 'BBQ Pork Sloppy Joes', 'https://www.themealdb.com/images/media/meals/atd5sh1583188467.jpg', 52995, 7),
(468, 'Bigos (Hunters Stew)', 'https://www.themealdb.com/images/media/meals/md8w601593348504.jpg', 53018, 7),
(469, 'Boxty Breakfast', 'https://www.themealdb.com/images/media/meals/naqyel1608588563.jpg', 53036, 7),
(470, 'Coddled pork with cider', 'https://www.themealdb.com/images/media/meals/7vpsfp1608588991.jpg', 53037, 7),
(471, 'Crispy Sausages and Greens', 'https://www.themealdb.com/images/media/meals/st1ifa1583267248.jpg', 52999, 7),
(472, 'Ham hock colcannon', 'https://www.themealdb.com/images/media/meals/n41ny81608588066.jpg', 53035, 7),
(473, 'Hot and Sour Soup', 'https://www.themealdb.com/images/media/meals/1529445893.jpg', 52954, 7),
(474, 'Japanese Katsudon', 'https://www.themealdb.com/images/media/meals/d8f6qx1604182128.jpg', 53034, 7),
(475, 'Pork Cassoulet', 'https://www.themealdb.com/images/media/meals/wxuvuv1511299147.jpg', 52847, 7),
(476, 'Portuguese barbecued pork (Febras assadas)', 'https://www.themealdb.com/images/media/meals/cybyue1614349443.jpg', 53044, 7),
(477, 'Skillet Apple Pork Chops with Roasted Sweet Potatoes & Zucchini', 'https://www.themealdb.com/images/media/meals/h3ijwo1581013377.jpg', 52994, 7),
(478, 'Stamppot', 'https://www.themealdb.com/images/media/meals/hyarod1565090529.jpg', 52980, 7),
(479, 'Sweet and Sour Pork', 'https://www.themealdb.com/images/media/meals/1529442316.jpg', 52949, 7),
(480, 'Toad In The Hole', 'https://www.themealdb.com/images/media/meals/ytuvwr1503070420.jpg', 52822, 7),
(481, 'Tonkatsu pork', 'https://www.themealdb.com/images/media/meals/lwsnkl1604181187.jpg', 53032, 7),
(482, 'Tourtiere', 'https://www.themealdb.com/images/media/meals/ytpstt1511814614.jpg', 52926, 7),
(483, 'Vietnamese Grilled Pork (bun-thit-nuong)', 'https://www.themealdb.com/images/media/meals/qqwypw1504642429.jpg', 52828, 7),
(484, 'Wontons', 'https://www.themealdb.com/images/media/meals/1525876468.jpg', 52948, 7),
(485, 'Boulangère Potatoes', 'https://www.themealdb.com/images/media/meals/qywups1511796761.jpg', 52914, 9),
(486, 'Brie wrapped in prosciutto & brioche', 'https://www.themealdb.com/images/media/meals/qqpwsy1511796276.jpg', 52913, 9),
(487, 'Burek', 'https://www.themealdb.com/images/media/meals/tkxquw1628771028.jpg', 53060, 9),
(488, 'Corba', 'https://www.themealdb.com/images/media/meals/58oia61564916529.jpg', 52977, 9),
(489, 'Fennel Dauphinoise', 'https://www.themealdb.com/images/media/meals/ytttsv1511798734.jpg', 52919, 9),
(490, 'Feteer Meshaltet', 'https://www.themealdb.com/images/media/meals/9f4z6v1598734293.jpg', 53030, 9),
(491, 'French Onion Soup', 'https://www.themealdb.com/images/media/meals/xvrrux1511783685.jpg', 52903, 9),
(492, 'Fresh sardines', 'https://www.themealdb.com/images/media/meals/nv5lf31628771380.jpg', 53061, 9),
(493, 'Japanese gohan rice', 'https://www.themealdb.com/images/media/meals/kw92t41604181871.jpg', 53033, 9),
(494, 'Kumpir', 'https://www.themealdb.com/images/media/meals/mlchx21564916997.jpg', 52978, 9),
(495, 'Mushroom soup with buckwheat', 'https://www.themealdb.com/images/media/meals/1ngcbf1628770793.jpg', 53059, 9),
(496, 'Mustard champ', 'https://www.themealdb.com/images/media/meals/o7p9581608589317.jpg', 53038, 9),
(497, 'Pierogi (Polish Dumplings)', 'https://www.themealdb.com/images/media/meals/45xxr21593348847.jpg', 53019, 9),
(498, 'Prawn & Fennel Bisque', 'https://www.themealdb.com/images/media/meals/rtwwvv1511799504.jpg', 52922, 9),
(499, 'Snert (Dutch Split Pea Soup)', 'https://www.themealdb.com/images/media/meals/9ptx0a1565090843.jpg', 52981, 9),
(500, 'Split Pea Soup', 'https://www.themealdb.com/images/media/meals/xxtsvx1511814083.jpg', 52925, 9),
(501, 'Broccoli & Stilton soup', 'https://www.themealdb.com/images/media/meals/tvvxpv1511191952.jpg', 52842, 10),
(502, 'Clam chowder', 'https://www.themealdb.com/images/media/meals/rvtvuw1511190488.jpg', 52840, 10),
(503, 'Cream Cheese Tart', 'https://www.themealdb.com/images/media/meals/wurrux1468416624.jpg', 52779, 10),
(504, 'Creamy Tomato Soup', 'https://www.themealdb.com/images/media/meals/stpuws1511191310.jpg', 52841, 10),
(505, 'Roast fennel and aubergine paella', 'https://www.themealdb.com/images/media/meals/1520081754.jpg', 52942, 11),
(506, 'Vegan Chocolate Cake', 'https://www.themealdb.com/images/media/meals/qxutws1486978099.jpg', 52794, 11),
(507, 'Vegan Lasagna', 'https://www.themealdb.com/images/media/meals/rvxxuy1468312893.jpg', 52775, 11),
(508, 'Baingan Bharta', 'https://www.themealdb.com/images/media/meals/urtpqw1487341253.jpg', 52807, 12),
(509, 'Chickpea Fajitas', 'https://www.themealdb.com/images/media/meals/tvtxpq1511464705.jpg', 52870, 12),
(510, 'Dal fry', 'https://www.themealdb.com/images/media/meals/wuxrtu1483564410.jpg', 52785, 12),
(511, 'Egg Drop Soup', 'https://www.themealdb.com/images/media/meals/1529446137.jpg', 52955, 12),
(512, 'Flamiche', 'https://www.themealdb.com/images/media/meals/wssvvs1511785879.jpg', 52906, 12),
(513, 'Ful Medames', 'https://www.themealdb.com/images/media/meals/lvn2d51598732465.jpg', 53025, 12),
(514, 'Gigantes Plaki', 'https://www.themealdb.com/images/media/meals/b79r6f1585566277.jpg', 53012, 12),
(515, 'Kafteji', 'https://www.themealdb.com/images/media/meals/1bsv1q1560459826.jpg', 52971, 12),
(516, 'Kidney Bean Curry', 'https://www.themealdb.com/images/media/meals/sywrsu1511463066.jpg', 52868, 12),
(517, 'Koshari', 'https://www.themealdb.com/images/media/meals/4er7mj1598733193.jpg', 53027, 12),
(518, 'Leblebi Soup', 'https://www.themealdb.com/images/media/meals/x2fw9e1560460636.jpg', 52973, 12),
(519, 'Matar Paneer', 'https://www.themealdb.com/images/media/meals/xxpqsy1511452222.jpg', 52865, 12),
(520, 'Moroccan Carrot Soup', 'https://www.themealdb.com/images/media/meals/jcr46d1614763831.jpg', 53047, 12),
(521, 'Mushroom & Chestnut Rotolo', 'https://www.themealdb.com/images/media/meals/ssyqwr1511451678.jpg', 52864, 12),
(522, 'Provençal Omelette Cake', 'https://www.themealdb.com/images/media/meals/qwtrtp1511799242.jpg', 52921, 12),
(523, 'Ratatouille', 'https://www.themealdb.com/images/media/meals/wrpwuu1511786491.jpg', 52908, 12),
(524, 'Ribollita', 'https://www.themealdb.com/images/media/meals/xrrwpx1487347049.jpg', 52811, 12),
(525, 'Roasted Eggplant With Tahini, Pine Nuts, and Lentils', 'https://www.themealdb.com/images/media/meals/ysqrus1487425681.jpg', 52816, 12),
(526, 'Shakshuka', 'https://www.themealdb.com/images/media/meals/g373701551450225.jpg', 52963, 12),
(527, 'Smoky Lentil Chili with Squash', 'https://www.themealdb.com/images/media/meals/uwxqwy1483389553.jpg', 52784, 12),
(528, 'Spanish Tortilla', 'https://www.themealdb.com/images/media/meals/quuxsx1511476154.jpg', 52872, 12),
(529, 'Spicy Arrabiata Penne', 'https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg', 52771, 12),
(530, 'Spicy North African Potato Salad', 'https://www.themealdb.com/images/media/meals/urtwux1486983078.jpg', 52797, 12),
(531, 'Spinach & Ricotta Cannelloni', 'https://www.themealdb.com/images/media/meals/wspuvp1511303478.jpg', 52849, 12),
(532, 'Squash linguine', 'https://www.themealdb.com/images/media/meals/wxswxy1511452625.jpg', 52866, 12),
(533, 'Stovetop Eggplant With Harissa, Chickpeas, and Cumin Yogurt', 'https://www.themealdb.com/images/media/meals/yqwtvu1487426027.jpg', 52817, 12),
(534, 'Summer Pistou', 'https://www.themealdb.com/images/media/meals/rqtxvr1511792990.jpg', 52911, 12),
(535, 'Tahini Lentils', 'https://www.themealdb.com/images/media/meals/vpxyqt1511464175.jpg', 52869, 12),
(536, 'Tamiya', 'https://www.themealdb.com/images/media/meals/n3xxd91598732796.jpg', 53026, 12),
(537, 'Vegetarian Casserole', 'https://www.themealdb.com/images/media/meals/vptwyt1511450962.jpg', 52863, 12),
(538, 'Vegetarian Chilli', 'https://www.themealdb.com/images/media/meals/wqurxy1511453156.jpg', 52867, 12),
(539, 'Yaki Udon', 'https://www.themealdb.com/images/media/meals/wrustq1511475474.jpg', 52871, 12),
(540, 'Mbuzi Choma (Roasted Goat)', 'https://www.themealdb.com/images/media/meals/cuio7s1555492979.jpg', 52968, 14);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng meals
--
ALTER TABLE meals
  ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng meals
--
ALTER TABLE meals
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=541;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
