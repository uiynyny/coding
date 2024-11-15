import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SprialMatrix
 */
public class SprialMatrix {

    public static void main(String[] args) {
        int[][] a = {
                { 1426, 1119, 481, 1894, 314, 1130, 2251, 2370, 2111, 1512, 302, 1007, 1462, 1003, 2182, 1102, 1292,
                        1477, 1161, 581, 2152, 258, 1052, 1896, 422, 848, 1065, 1374, 1895, 2309, 1582 },
                { 977, 348, 1711, 1948, 2253, 399, 1989, 2195, 2282, 143, 1720, 1893, 360, 2160, 1143, 1011, 2290, 96,
                        1377, 1398, 1729, 1816, 1723, 2053, 1221, 2250, 626, 2038, 2404, 385, 1891 },
                { 199, 679, 2066, 552, 56, 2052, 1111, 544, 466, 1684, 661, 806, 383, 1571, 1584, 1688, 2301, 1192,
                        1513, 951, 822, 2250, 827, 984, 947, 1109, 394, 2152, 579, 2333, 491 },
                { 1367, 139, 1174, 1963, 2005, 2375, 2093, 548, 11, 1358, 1849, 194, 360, 343, 1489, 244, 781, 1422,
                        1219, 2093, 1143, 1742, 2227, 1604, 1118, 1768, 117, 2434, 1060, 503, 1847 },
                { 1232, 169, 2447, 2383, 1166, 1432, 2387, 89, 897, 14, 2453, 2248, 1754, 2131, 2414, 1209, 2190, 2316,
                        578, 2120, 2439, 2091, 1006, 227, 1848, 1825, 2323, 614, 1398, 573, 437 },
                { 962, 1815, 948, 1323, 480, 1787, 267, 1255, 2421, 2195, 509, 88, 2193, 393, 1939, 329, 667, 1136,
                        1230, 69, 2288, 380, 1917, 1710, 2028, 1111, 1536, 2430, 773, 864, 853 },
                { 2058, 1382, 1506, 2092, 2416, 787, 1297, 1201, 2257, 117, 106, 35, 251, 1979, 2361, 2422, 1803, 105,
                        830, 1138, 1429, 1051, 576, 2430, 389, 341, 2170, 526, 54, 578, 776 },
                { 218, 2345, 863, 762, 787, 996, 2317, 1456, 1775, 455, 442, 2386, 118, 1975, 1476, 290, 383, 1276,
                        1095, 1364, 2014, 1416, 1271, 556, 1358, 810, 447, 1545, 573, 2376, 519 },
                { 1462, 2128, 2081, 883, 945, 1200, 802, 854, 1526, 1928, 2142, 1675, 634, 1567, 1524, 2146, 2001, 71,
                        2099, 1792, 1872, 1085, 2289, 559, 1930, 1383, 187, 754, 1376, 671, 1650 },
                { 723, 528, 2326, 754, 926, 366, 633, 413, 1824, 1027, 786, 119, 1121, 2237, 1816, 2216, 543, 780, 1661,
                        788, 1509, 986, 584, 755, 1501, 1540, 2212, 912, 779, 1933, 1496 },
                { 422, 636, 1737, 343, 1585, 2332, 1717, 2010, 2426, 812, 894, 561, 1955, 1015, 1564, 568, 1079, 543,
                        1466, 1386, 1895, 1420, 1253, 332, 723, 2320, 1448, 1313, 2168, 1441, 1900 },
                { 1943, 693, 1277, 1870, 664, 2161, 1410, 346, 1440, 1255, 410, 1564, 387, 1508, 2108, 1015, 393, 515,
                        144, 1592, 1256, 2301, 266, 1646, 2422, 598, 2305, 1993, 1185, 1666, 1015 },
                { 475, 2222, 337, 2284, 2206, 1944, 1884, 409, 1881, 369, 1984, 2060, 1658, 1212, 621, 139, 2264, 1792,
                        677, 267, 946, 334, 1443, 19, 2192, 472, 1581, 1597, 1319, 527, 634 },
                { 1298, 1696, 2341, 777, 1282, 1946, 471, 1027, 442, 336, 1432, 683, 1811, 154, 112, 1282, 1671, 2007,
                        1745, 239, 426, 1173, 1923, 35, 656, 536, 458, 556, 757, 89, 1550 },
                { 1468, 1003, 118, 47, 905, 1934, 1035, 2092, 2093, 935, 1396, 2188, 2048, 583, 1941, 787, 961, 1932,
                        2415, 1138, 2462, 636, 152, 540, 1754, 1740, 2338, 1481, 1510, 844, 2129 },
                { 2280, 2310, 576, 2130, 1355, 2195, 29, 1907, 1743, 1033, 2265, 32, 2362, 626, 1608, 2112, 1458, 1601,
                        1679, 1154, 459, 766, 865, 1415, 58, 1406, 1396, 832, 2185, 1549, 1332 },
                { 390, 1121, 793, 945, 594, 202, 922, 2257, 2413, 1625, 81, 2134, 1206, 804, 2199, 1126, 120, 705, 1642,
                        907, 1129, 1257, 269, 2475, 2303, 658, 1228, 1902, 140, 2260, 1759 },
                { 1790, 2132, 944, 258, 2477, 1287, 1392, 2467, 2342, 1095, 991, 1877, 2200, 2423, 2383, 1758, 1460,
                        929, 1681, 2246, 1573, 727, 1840, 53, 2435, 1622, 2174, 1041, 2309, 1775, 361 },
                { 2019, 2374, 1324, 1332, 1388, 1092, 292, 887, 2393, 2145, 604, 2057, 702, 2011, 841, 1470, 1251, 916,
                        2274, 456, 1304, 307, 1259, 1687, 423, 585, 2115, 1025, 1774, 460, 1940 },
                { 1022, 986, 954, 1053, 964, 1904, 202, 2457, 1197, 1831, 685, 1602, 1857, 594, 1437, 1546, 1448, 724,
                        898, 1806, 1461, 2399, 981, 2081, 1431, 1397, 1685, 1829, 1970, 1198, 1985 },
                { 1157, 1850, 1068, 1357, 1680, 941, 1292, 787, 515, 243, 15, 2452, 1734, 433, 1577, 2081, 1256, 981,
                        1814, 44, 2444, 2320, 904, 2069, 1065, 1123, 446, 909, 61, 2277, 2178 },
                { 2018, 1548, 2426, 1878, 811, 1173, 2108, 1827, 2371, 2156, 1279, 1305, 795, 600, 608, 2193, 113, 694,
                        1647, 2091, 1093, 2429, 338, 1994, 130, 546, 2097, 260, 963, 2175, 404 },
                { 809, 593, 546, 1066, 224, 1091, 1293, 1410, 2179, 2228, 1645, 966, 2136, 1452, 57, 310, 1113, 780,
                        1886, 2314, 186, 2218, 2476, 1285, 661, 1710, 1261, 2065, 1805, 90, 1794 },
                { 737, 380, 126, 712, 1632, 2377, 890, 2078, 963, 1864, 680, 1140, 1803, 2201, 2059, 1590, 1474, 755,
                        351, 1017, 115, 2400, 572, 1470, 389, 2440, 436, 1303, 1509, 1465, 1520 },
                { 1692, 1131, 864, 1634, 108, 1412, 1201, 1050, 570, 2260, 1667, 209, 1877, 2263, 383, 2317, 1244, 2451,
                        231, 1512, 995, 163, 1816, 683, 1373, 1016, 2112, 1220, 2379, 2128, 2289 },
                { 2116, 2230, 1710, 176, 826, 1506, 646, 966, 2400, 368, 1900, 63, 16, 1470, 2301, 1158, 1563, 592,
                        2138, 501, 1159, 651, 1386, 1513, 821, 850, 2335, 2438, 1577, 651, 1883 },
                { 739, 1740, 1625, 1556, 1480, 2251, 1122, 2300, 465, 681, 1451, 1874, 2469, 292, 398, 1822, 2093, 1911,
                        2042, 284, 467, 2010, 143, 792, 1387, 814, 776, 1954, 1871, 236, 2047 },
                { 1392, 2284, 2298, 1828, 1124, 1685, 1761, 2382, 1196, 1580, 1695, 795, 896, 2094, 620, 1351, 1004,
                        2022, 914, 2458, 1880, 2280, 430, 1845, 1594, 1922, 360, 862, 1647, 969, 159 },
                { 258, 249, 2210, 1979, 1192, 332, 1026, 1011, 135, 997, 1936, 104, 1646, 2104, 540, 417, 2256, 1251,
                        129, 2360, 770, 2052, 2439, 462, 1217, 840, 484, 1514, 469, 1719, 1197 },
                { 549, 1140, 317, 630, 1554, 783, 888, 1022, 2058, 1457, 1140, 1146, 325, 1717, 833, 2132, 1412, 1640,
                        1607, 1677, 143, 2266, 1278, 386, 257, 1146, 1894, 1449, 1270, 40, 2301 },
                { 719, 1204, 279, 1463, 2014, 2307, 1217, 909, 2152, 2450, 1329, 895, 1614, 2148, 1036, 1174, 80, 1460,
                        862, 1456, 358, 628, 501, 91, 677, 1949, 67, 1551, 2261, 890, 2322 },
                { 852, 798, 1961, 1502, 1230, 1678, 86, 1883, 589, 1996, 784, 1028, 81, 1294, 2342, 858, 925, 1527,
                        1667, 166, 1259, 440, 614, 754, 1710, 649, 2399, 1703, 1729, 1835, 1494 },
                { 760, 2151, 520, 521, 1472, 2374, 1524, 2480, 1568, 857, 1002, 1711, 300, 692, 1322, 1677, 1193, 2467,
                        2458, 1351, 474, 2140, 2166, 1543, 1007, 904, 488, 1167, 2262, 1179, 1538 },
                { 2005, 770, 2245, 1227, 737, 1329, 670, 1596, 1610, 2168, 1532, 2114, 220, 494, 1875, 842, 1093, 860,
                        589, 2422, 451, 1910, 2062, 362, 1185, 1368, 199, 2101, 1293, 2100, 1507 },
                { 1196, 1151, 1666, 2211, 1090, 2040, 1291, 688, 169, 233, 611, 516, 938, 2389, 2180, 1514, 539, 2113,
                        1155, 897, 924, 2184, 1129, 1561, 457, 1353, 505, 2346, 2294, 2352, 661 },
                { 1182, 55, 1724, 1644, 1460, 625, 820, 730, 568, 1412, 2085, 943, 1986, 1106, 2326, 458, 1026, 838,
                        1404, 576, 1178, 352, 2372, 784, 1703, 2445, 521, 421, 364, 52, 2155 },
                { 2273, 482, 404, 1403, 349, 2377, 909, 895, 363, 832, 1466, 2026, 872, 2249, 2031, 857, 415, 1109,
                        2250, 2026, 1800, 738, 2424, 808, 1737, 2277, 1685, 1252, 1139, 687, 1400 },
                { 1623, 16, 1217, 548, 2470, 1464, 1970, 1546, 1236, 349, 1842, 1564, 1108, 2028, 1756, 1896, 778, 1348,
                        745, 1562, 265, 1757, 2397, 1304, 637, 777, 926, 1231, 627, 1982, 13 },
                { 1811, 193, 2206, 775, 1938, 1202, 1449, 179, 1048, 1683, 2144, 1704, 729, 1664, 1018, 1864, 1390, 144,
                        1478, 1236, 1666, 1766, 57, 1785, 754, 593, 1927, 1784, 1090, 707, 1195 },
                { 1684, 2128, 2228, 662, 596, 2336, 801, 2126, 1871, 1366, 2312, 1088, 1563, 974, 1708, 329, 835, 858,
                        26, 2201, 1393, 2252, 1512, 2114, 1554, 190, 1449, 147, 1137, 2283, 221 } };
        SprialMatrix sm=new SprialMatrix();
        System.out.println(sm.solve(a));
    }

    private List<Integer> solve(int[][] matrix) {
        if (matrix.length == 0)
            return Collections.emptyList();
        int lb = 0, rb = matrix[0].length - 1, ub = 0, bb = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (lb <= rb && ub <= bb) {
            // top row
            for (int i = lb; i <= rb; i++) {
                res.add(matrix[ub][i]);
            }
            ub++;
            // right col
            for (int j = ub; j <= bb; j++) {
                res.add(matrix[j][rb]);
            }
            rb--;
            if (ub > bb)
                break;
            // bottom row
            for (int i = rb; i >= lb; i--) {
                res.add(matrix[bb][i]);
            }
            bb--;
            // left col
            for (int j = bb; j >= ub; j--) {
                res.add(matrix[j][lb]);
            }
            lb++;
        }
        return res;
    }
}