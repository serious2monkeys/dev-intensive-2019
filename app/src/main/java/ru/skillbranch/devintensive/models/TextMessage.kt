package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.format
import java.util.*

/**
 * Текстовое сообщение
 */
class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    /**
     * {@inheritDoc}
     */
    override fun formatMessage(): String = "Текстовое сообщение \"(${text
        ?: "Пусто"})\" отправлено пользователем ${from?.firstName} ${from?.lastName} в беседу ${chat.id} ${date.format()}"
}