package eu.kanade.tachiyomi.extension.pt.nexustoons

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class NexusToons : Madara(
    "NexusToons",
    "https://nexustoons.com",
    "pt-BR",
    SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
) {
    override val id: Long = 8821034509234567L

    // NexusToons usa o seletor padrão do Madara para imagens de capítulo
    override val useNewChapterEndpoint = true

    // Ajuste de nome do manga no seletor (padrão Madara PT)
    override fun chapterFromElement(element: org.jsoup.nodes.Element) =
        super.chapterFromElement(element)
}
