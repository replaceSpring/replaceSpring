$(document).ready(function(){
    const $ul = $(".css-73s7lu");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    let text = "";
    positions.forEach(position => {
        text += `
                                            <li class="css-iftixr">
                                    <div class="css-1d944kd">
                                        <div tabindex="0" class="css-1qc8ju8"><a draggable="false"
                                                                                 href="/ko/products/5c5d780974eabcfdafd39897">
                                            <div class="css-8atqhb">
                                                <div class="css-mgewzr">
                                                    <div class="css-1ct1iq3">
                                                        <div class="css-abev78">
                                                            <div class="css-60ifsp"
                                                                 style="color: rgb(243, 243, 243); --system-on-color: #f3f3f3;">
                                                                <picture data-testid="image" class="css-eti150">
                                                                    <source type="image/webp"
                                                                            srcset="https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/640xauto.webp 640w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/750xauto.webp 750w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/828xauto.webp 828w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1080xauto.webp 1080w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1200xauto.webp 1200w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1920xauto.webp 1920w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/2048xauto.webp 2048w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/3840xauto.webp 3840w"
                                                                            sizes="(max-width: 640px) 160px,(max-width: 1024px) 200px,250px">
                                                                    <img class="css-1u3hmek" draggable="false" alt=""
                                                                         srcset="https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/640xauto 640w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/750xauto 750w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/828xauto 828w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1080xauto 1080w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1200xauto 1200w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/1920xauto 1920w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/2048xauto 2048w,https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26/3840xauto 3840w"
                                                                         src="https://cdn.class101.net/images/110df2e9-4513-4d54-982c-1e795b084e26"
                                                                         sizes="(max-width: 640px) 160px,(max-width: 1024px) 200px,250px"
                                                                         loading="eager"></picture>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="css-1h9gj2l"><h2 data-testid="title" class="css-es3o19">${position.positionName}
                                                </h2><span class="css-1k0q1kx"></span>
                                                <h2 data-testid="body" class="css-o90gdq">${position.midCategoryName}|${position.companyName}</h2>
                                            </div>
                                        </a></div>
                                        <div class="css-60ifsp"
                                             style="color: rgb(243, 243, 243); --system-on-color: #f3f3f3;">
                                            <div class="css-j50c81">
                                                <button type="button" data-testid="icon-button" class="css-1dcq9or"
                                                        style="opacity: 1; transition-property: opacity; transition-duration: 200ms; transition-timing-function: cubic-bezier(0.5, 1, 0.89, 1);">
                                                    <svg viewBox="0 0 24 24" data-testid="heart-thin"
                                                         class="css-1devemn">
                                                        <path d="M20.75 4.8C19.55 3.6 18 3 16.45 3c-1.55 0-3.1.6-4.3 1.8-.05.05-.1.15-.15.2a.69.69 0 0 1-.15-.2C10.65 3.6 9.1 3 7.55 3c-1.55 0-3.1.6-4.3 1.8-2.35 2.4-2.35 6.35 0 8.75 2.35 2.4 8.55 8.35 8.55 8.35.05.1.15.1.2.1.05 0 .15 0 .15-.05 0 0 6.2-5.95 8.55-8.35 2.35-2.4 2.4-6.35.05-8.8ZM12 7.35c.35 0 .45-.4.75-.8 1.6-1.85 4.25-2.4 6.25-.9 1.3 1 1.95 2.75 1.65 4.35-.3 1.7-1.75 2.9-3 4.2-.65.65-5.65 5.4-5.65 5.4s-5-4.75-5.65-5.4c-1.25-1.25-2.7-2.5-3-4.2-.3-1.6.35-3.4 1.65-4.35 2-1.5 4.65-1 6.2.9.35.4.45.8.8.8Z"
                                                              class="css-17f4zqp"></path>
                                                    </svg>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </li>
        `
    });

    $ul.html(text);
});