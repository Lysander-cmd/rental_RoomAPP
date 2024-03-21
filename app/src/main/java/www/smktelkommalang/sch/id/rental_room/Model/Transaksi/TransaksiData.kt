package www.smktelkommalang.sch.id.rental_room.Model.Transaksi

data class TransaksiData(
    val title: String,
    val date: String,
    val time: String,
    val status: String,
    val image: String,
) {

}
/*
membantu dalam urutan data, pastikan urutan data sesuai dengan pengaplikasian UI (data bisa ketuker krn urutan)

misal: val date paling awal sebelum title, hasilnya data yang direpresentasikan di UI terbalik
 */