# Übersetzung der Aufgabenstellung 
Die Vorbereitungen sind endlich abgeschlossen; du und die Elfen verlassen das Lager zu Fuß und machen sich auf den Weg zum Sternfruchthain.

Während ihr euch durch das dichte Unterholz bewegt, gibt euch einer der Elfen ein tragbares Gerät. Er sagt, dass es viele ausgefallene Funktionen hat, aber die wichtigste, die du jetzt einrichten musst, ist das Kommunikationssystem.

Da er jedoch gehört hat, dass du viel Erfahrung im Umgang mit signalbasierten Systemen hast, hat er die anderen Elfen davon überzeugt, dass es in Ordnung ist, dir ihr einziges defektes Gerät zu geben - du wirst sicher kein Problem haben, es zu reparieren.

Wie von einem komödiantischen Timing inspiriert, stößt das Gerät ein paar bunte Funken aus.

Um mit den Elfen kommunizieren zu können, muss sich das Gerät auf ihr Signal einstellen. Das Signal ist eine Reihe von scheinbar zufälligen Zeichen, die das Gerät nacheinander empfängt.

Um das Kommunikationssystem zu reparieren, müssen Sie dem Gerät eine Unterroutine hinzufügen, die eine Paketanfangsmarkierung im Datenstrom erkennt. In dem von den Elfen verwendeten Protokoll wird der Beginn eines Pakets durch eine Folge von vier Zeichen angezeigt, die alle unterschiedlich sind.

Das Gerät sendet Ihrem Unterprogramm einen Datenstrompuffer (Ihre Rätseleingabe); Ihr Unterprogramm muss die erste Position identifizieren, an der die vier zuletzt empfangenen Zeichen alle unterschiedlich waren. Insbesondere muss es die Anzahl der Zeichen vom Anfang des Puffers bis zum Ende der ersten solchen Vier-Zeichen-Markierung melden.

Nehmen wir zum Beispiel an, Sie erhalten den folgenden Datenstrompuffer:

mjqjpqmgbljsphdztnvjfqwrcgsmlb
Nachdem die ersten drei Zeichen (mjq) empfangen wurden, sind noch nicht genug Zeichen empfangen worden, um die Markierung zu finden. Das erste Mal, dass eine Markierung auftreten könnte, ist nach dem Empfang des vierten Zeichens, so dass die letzten vier Zeichen mjqj sind. Da j wiederholt wird, handelt es sich nicht um eine Marke.

Das erste Mal, dass eine Markierung auftaucht, ist nach dem siebten Zeichen. Danach sind die letzten vier empfangenen Zeichen jpqm, die alle unterschiedlich sind. In diesem Fall sollte Ihr Unterprogramm den Wert 7 melden, da die erste Start-of-Packet-Marke nach der Verarbeitung von 7 Zeichen abgeschlossen ist.

