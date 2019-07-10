package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Сообщение с изображением
 */
class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    /**
     * {@inheritDoc}
     */
    override fun formatMessage(): String =
        "Id: $id ${from?.firstName} ${if (isIncoming) "получил" else "отправил"} изображение \"$image\" ${date.humanizeDiff()}"
}