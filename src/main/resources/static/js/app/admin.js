var admin = {
    init : function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-update').on('click', function () {
            _this.update()
        })
    },
    save : function () {
        var token = $('input#csrf-token').attr("value");
        var data = {
            kinds: $('#kinds').val(),
            title: $('#title').val(),
            author: $('#author').val(),
            counts: $('#counts').val(),
            price: $('#price').val()
        };

        $.ajax({
            type: 'POST',
            url: '/books/insert',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('책이 등록되었습니다.');
            location.reload();
        }).fail(function () {
            alert("잘못된 입력입니다.");
        });
    },
    delete : function () {
        var token = $('input#csrf-token').attr("value");
        var data = {
            id: $('#deleteId').val()
        };

        $.ajax({
            type: 'POST',
            url: '/books/delete',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('책이 삭제되었습니다.');
            location.reload();
        }).fail(function () {
            alert("잘못된 Id 값이 입력되었습니다.");
        });
    },
    update : function () {
        var token = $('input#csrf-token').attr("value");
        var data = {
            id: $('#update_id').val(),
            kinds: $('#update_kinds').val(),
            title: $('#update_title').val(),
            author: $('#update_author').val(),
            counts: $('#update_counts').val(),
            price: $('#update_price').val()
        };

        $.ajax({
            type: 'POST',
            url: '/books/update',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('책의 정보가 수정되었습니다.');
            location.reload();
        }).fail(function () {
            alert("잘못된 입력입니다.");
        });
    }
};

admin.init();
