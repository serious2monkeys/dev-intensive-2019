package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.format
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
    override fun formatMessage(): String = "Изображение (${image
        ?: "Нет картинки"}) отправлено пользователем ${from?.firstName} ${from?.lastName} в беседу ${chat.id} ${date.format()}"
}