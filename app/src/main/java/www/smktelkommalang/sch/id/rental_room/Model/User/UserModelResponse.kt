package www.smktelkommalang.sch.id.rental_room.Model.User

import www.smktelkommalang.sch.id.rental_room.Model.User.UserData

data class UserModelResponse (
    val item: UserData? = UserData(),
    val key: String? = ""
)