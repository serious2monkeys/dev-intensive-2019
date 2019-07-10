package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView =
    UserView(
        id = id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        status = if (lastVisit == null) "Еще не был" else if (isOnline) "online" else "Последний раз был ${lastVisit?.humanizeDiff()}",
        initials = Utils.toInitials(firstName, lastName),
        nickName = Utils.transliteration("$firstName $lastName")
    )