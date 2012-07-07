delete from barang_di_inventory;
delete from barang;
delete from inventory;
delete from referensi;


INSERT INTO `referensi` (`id`, `grup`, `keterangan`, `kode`, `nama`, `nilai`, `num`) VALUES (1, 0, 'grup', 'grup', 'grup', NULL, NULL);

INSERT INTO `barang` (`id`, `created`, `harga`, `merk`, `nama`, `saldo`, `satuan`) VALUES (1, '2012-07-06 19:59:41', 5000.00, 'Ultra', 'Susu', 500.00, 'BOX');
INSERT INTO `barang` (`id`, `created`, `harga`, `merk`, `nama`, `saldo`, `satuan`) VALUES (2, '2012-07-06 19:59:41', 4500.00, 'Sosro', 'Teh', 350.00, 'BOX');

INSERT INTO `inventory` (`id`, `alamat`, `nama`, `jenis`, `metode`) VALUES (1, 'Jakarta', 'Main Warehouse', 1, 1);

INSERT INTO `barang_di_inventory` (`id`, `barang`, `inventory`) VALUES (1, 1, 1);
INSERT INTO `barang_di_inventory` (`id`, `barang`, `inventory`) VALUES (2, 2, 1);

