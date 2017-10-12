# bug-tracker
testing task

Тестовое задание
на должность J2EE разработчика
Тестовое задание состоит в написании системы баг трекинга. На выполнение задания отводится две недели с момента получения.
Для реализации задания следует использовать следующие технологии:
PostgreSQL+ Hibernate для сохранения данных
JSF для отображения
Tomcat в качестве контейнера для приложения
Maven в качестве системы сборки проекта
Описание системы
Система представляет собой простейший баг трекер. При этом система оперирует следующими объектами:
Баг — описание ошибки. Помимо стандартных полей должен содержать автора (пользователя который добавил баг) и исполнителя (пользователя, которому баг приасайнен).
Пользователь системы — разработчик или тестер или просто пользователь (без разделения ролей). Т.е. любой пользователь может быть как автором бага так и исполнителем.
Администратор системы — особый привилегированный пользователь. Детали см. в «Сценариях использования системы».
Сценарии использования системы:
Работа от имени администратора системы.
1. Пользователь логинится в системе как администратор.
2. Он видит список всех пользователей, может их добавлять и редактировать.
3. Он видит список всех багов. Может их добавлять, редактировать и удалять.
Работа от имени пользователя системы
1. Пользователь логинится в системе.
2. Пользователь видит список всех багов, исполнителем которых является («мои баги»). Управление «Моими багами» не оговаривается и остается на ваше усмотрение. Естественно оно не должно противоречить логике работы системы баг-трекинга (т. е. пользователь не должен иметь возможности например просто удалить баг, исполнителем которого он является)
3. Пользователь видит список багов, автором которых он является. Пользователь имеет возможность добавить новый баг и отредактировать один из существующих. Баги других пользователей ему недоступны.

Оценивание
Оцениваются следующие характеристики системы:
1. Соответствие заданию
2. Наличие явных багов
3. Использование технологий
4. Стиль кодирования
Дизайн пользовательского интерфейса остается на ваше усмотрение.
Расширение функционала системы остается на ваше усмотрение и будет дополнительным плюсом.
Обоснованное использование других технологий (дополнительно к указанным в задании) — например Spring – будет дополнительным плюсом.